package nextfs.disk.array;

import java.util.Objects;

public class ZoomedByteArray extends AbstractByteArray {

	private final ByteArray array;
	private final long start;
	private final long length;
	
	public ZoomedByteArray(ByteArray array, long start, long length) {
		Objects.checkFromIndexSize(start, length, array.length());
		this.array = array;
		this.start = start;
		this.length = length;
	}
	
	@Override
	public long length() {
		return length;
	}
	
	@Override
	public byte getByte(long index) {
		Objects.checkIndex(index, length);
		return array.getByte(start + index);
	}

	@Override
	public void setByte(long index, byte value) {
		Objects.checkIndex(index, length);
		array.setByte(start + index, value);
	}
}