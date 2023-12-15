package nextfs.disk.array;

public abstract class AbstractByteArray implements ByteArray {

	@Override
	public abstract byte getByte(long index);
	@Override
	public abstract void setByte(long index, byte value);

	
	private final long $get(long index, int size) {
		size--;
		long r = (long)getByte(index) << (size * 8);
		
		for (byte i = 1 ; i <= size ; i++)
			r += (getByte(index + i) & 0xFFl) << ((size - i) * 8);
		
		return r;
	}
	
	private final void $set(long index, int size, long value) {
		size--;
		for (byte i = 0 ; i <= size ; i++)
			setByte(index + i, (byte)(value >>> ((size - i) * 8)));
	}
	
	
	@Override
	public final long get(long index, int size) {
		if (size < 0 || size > 8)
			throw new IllegalArgumentException("size must be between 1 and 8");
		return $get(index, size);
	}
	
	@Override
	public final void set(long index, int size, long value) {
		if (size < 0 || size > 8)
			throw new IllegalArgumentException("size must be between 1 and 8");
		$set(index, size, value);
	}
	
	
	@Override
	public final boolean getBoolean(long index) {
		return getByte(index) != 0;
	}
	
	@Override
	public final void setBoolean(long index, boolean value) {
		setByte(index, (byte)(value ? 1 : 0));
	}
	
	
	@Override
	public final short getUnsignedByte(long index) {
		return (short)(getByte(index) & 0xFF);
	}
	
	@Override
	public final void setUnsignedByte(long index, short value) {
		setByte(index, (byte)value);
	}
	
	
	@Override
	public final short getShort(long index) {
		return (short)$get(index, 2);
	}
	
	@Override
	public final void setShort(long index, short value) {
		$set(index, 2, value);
	}
	
	@Override
	public final int getUnsignedShort(long index) {
		return (int)getShort(index) & 0xFFFF;
	}
	
	@Override
	public final void setUnsignedShort(long index, int value) {
		setShort(index, (short)value);
	}
	
	@Override
	public final char getChar(long index) {
		return (char)getShort(index);
	}
	
	@Override
	public final void setChar(long index, char value) {
		setShort(index, (short)value);
	}
	
	
	@Override
	public final int getInt(long index) {
		return (int)$get(index, 4);
	}
	
	@Override
	public final void setInt(long index, int value) {
		$set(index, 4, value);
	}
	
	@Override
	public final long getUnsignedInt(long index) {
		return (long)getInt(index) & 0xFFFFFFFFl;
	}
	
	@Override
	public final void setUnsignedInt(long index, long value) {
		setInt(index, (int)value);
	}
	
	
	@Override
	public final float getFloat(long index) {
		return Float.intBitsToFloat(getInt(index));
	}
	
	@Override
	public final void setFloat(long index, float value) {
		setInt(index, Float.floatToIntBits(value));
	}
	
	
	@Override
	public final long getLong(long index) {
		return $get(index, 8);
	}
	
	@Override
	public final void setLong(long index, long value) {
		$set(index, 8, value);
	}
	
	
	@Override
	public final double getDouble(long index) {
		return Double.longBitsToDouble(getLong(index));
	}
	
	@Override
	public final void setDouble(long index, double value) {
		setLong(index, Double.doubleToLongBits(value));
	}
	
	
	@Override
	public void get(long index, byte[] buffer, int length) {
		for (int i = 0 ; i < length ; i++)
			buffer[i] = getByte(index + i);
	}
	
	@Override
	public void set(long index, byte[] buffer, int length) {
		for (int i = 0 ; i < length ; i++)
			setByte(index + i, buffer[i]);
	}
	
	
	@Override
	public void get(long index, ByteArray buffer, int length) {
		for (int i = 0 ; i < length ; i++)
			buffer.setByte(i, getByte(index + i));
	}
	
	@Override
	public void set(long index, ByteArray buffer, int length) {
		for (int i = 0 ; i < length ; i++)
			setByte(index + i, buffer.getByte(i));
	}
	
	
	@Override
	public ByteArray zoomFromSize(long from, long size) {
		if (from == 0 && size == length())
			return this;
		return new ZoomedByteArray(this, from, size);
	}
	
	@Override
	public ByteArray zoomFromTo(long from, long to) {
		if (from == 0 && to == length())
			return this;
		return new ZoomedByteArray(this, from, to - from);
	}
	
	
	@Override
	public ByteArray extractFromSize(long from, int size) {
		byte[] arr = new byte[size];
		for (int i = 0 ; i < size ; i++)
			arr[i] = getByte(from + i);
		return ByteArray.wrap(arr);
	}
	
	@Override
	public ByteArray extractFromTo(long from, long to) {
		return extractFromSize(from, (int)(to - from));
	}
}