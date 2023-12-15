package nextfs.disk.array;

public interface ByteArray {

	public static ByteArray wrap(byte[] arr) {
		return new WrappedByteArray(arr);
	}
	
	public static ByteArray create(int size) {
		return new WrappedByteArray(size);
	}
	
	long length();
	
	byte getByte(long index);

	void setByte(long index, byte value);

	long get(long index, int size);

	void set(long index, int size, long value);

	boolean getBoolean(long index);

	void setBoolean(long index, boolean value);

	short getUnsignedByte(long index);

	void setUnsignedByte(long index, short value);

	short getShort(long index);

	void setShort(long index, short value);

	char getChar(long index);
	
	void setChar(long index, char value);
	
	int getUnsignedShort(long index);

	void setUnsignedShort(long index, int value);

	int getInt(long index);

	void setInt(long index, int value);

	long getUnsignedInt(long index);

	void setUnsignedInt(long index, long value);

	float getFloat(long index);

	void setFloat(long index, float value);

	long getLong(long index);

	void setLong(long index, long value);

	double getDouble(long index);

	void setDouble(long index, double value);

	void get(long index, byte[] buffer, int length);

	void set(long index, byte[] buffer, int length);

	void get(long index, ByteArray buffer, int length);

	void set(long index, ByteArray buffer, int length);

	ByteArray zoomFromTo(long from, long to);
	
	ByteArray zoomFromSize(long from, long size);
	
	ByteArray extractFromTo(long from, long to);
	
	ByteArray extractFromSize(long from, int size);
}