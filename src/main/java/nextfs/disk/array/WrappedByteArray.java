package nextfs.disk.array;

import java.util.Objects;

public class WrappedByteArray extends AbstractByteArray {

	public static WrappedByteArray wrap(byte[] array) {
		return new WrappedByteArray(array);
	}
	
	private final byte[] bytes;
	
	public WrappedByteArray(byte[] bytes) {
		this.bytes = Objects.requireNonNull(bytes, "bytes must not be null");
	}
	
	public WrappedByteArray(int size) {
		this.bytes = new byte[size];
	}
	
	@Override
	public long length() {
		return bytes.length;
	}

	@Override
	public byte getByte(long index) {
		return bytes[(int)index];
	}

	@Override
	public void setByte(long index, byte value) {
		bytes[(int)index] = value;
	}

}
