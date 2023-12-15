package nextfs.disk.array;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AbstractByteArrayTest {

	@Test
	void zoomTest() {
		ByteArray arr1 = ByteArray.create(16);
		ByteArray arr2 = arr1.zoomFromSize(5, 5);
		assertEquals(arr1.length(), 16);
		assertEquals(arr2.length(), 5);
		arr2.setByte(3, (byte)10);

		assertEquals(arr1.getByte(8), 10);
		assertEquals(arr2.getByte(3), 10);
		assertThrows(IndexOutOfBoundsException.class, () -> {arr2.getByte(-1);});
		assertThrows(IndexOutOfBoundsException.class, () -> {arr2.getByte(arr1.length());});
	}
	
	@Test
	void byteTest() {
		ByteArray arr = ByteArray.create(2);
		arr.setByte(0, (byte)10);
		arr.setByte(1, (byte)11);
		assertEquals(arr.getByte(0), 10);
		assertEquals(arr.getByte(1), 11);
	}
	
	@Test
	void ubyteTest() {
		ByteArray arr = ByteArray.create(2);
		arr.setUnsignedByte(0, (short)10);
		arr.setUnsignedByte(1, (short)156);
		assertEquals(arr.getUnsignedByte(0), 10);
		assertEquals(arr.getUnsignedByte(1), 156);
	}
	
	@Test
	void booleanTest() {
		ByteArray arr = ByteArray.create(2);
		arr.setBoolean(0, true);
		arr.setBoolean(1, false);
		assertTrue(arr.getBoolean(0));
		assertFalse(arr.getBoolean(1));
	}
	
	@Test
	void shortTest() {
		ByteArray arr = ByteArray.create(4);
		arr.setShort(0, (short)500);
		arr.setShort(2, (short)-545);
		assertEquals(arr.getShort(0), 500);
		assertEquals(arr.getShort(2), -545);
	}
	
	@Test
	void ushortTest() {
		ByteArray arr = ByteArray.create(4);
		arr.setUnsignedShort(0, 500);
		arr.setUnsignedShort(2, 60000);
		assertEquals(arr.getUnsignedShort(0), 500);
		assertEquals(arr.getUnsignedShort(2), 60000);
	}
	
	@Test
	void charTest() {
		ByteArray arr = ByteArray.create(4);
		arr.setChar(0, '²');
		arr.setChar(2, '~');
		assertEquals(arr.getChar(0), '²');
		assertEquals(arr.getChar(2), '~');
	}
	
	@Test
	void intTest() {
		ByteArray arr = ByteArray.create(8);
		arr.setInt(0, 500454);
		arr.setInt(4, -5458448);
		assertEquals(arr.getInt(0), 500454);
		assertEquals(arr.getInt(4), -5458448);
	}
	
	@Test
	void uintTest() {
		ByteArray arr = ByteArray.create(8);
		arr.setUnsignedInt(0, 4_000_000);
		arr.setUnsignedInt(4, 4_000_000_000l);
		assertEquals(arr.getUnsignedInt(0), 4_000_000);
		assertEquals(arr.getUnsignedInt(4), 4_000_000_000l);
	}

	@Test
	void floatTest() {
		ByteArray arr = ByteArray.create(8);
		arr.setFloat(0, 500454.0f);
		arr.setFloat(4, -5458448.34f);
		assertEquals(arr.getFloat(0), 500454.0f);
		assertEquals(arr.getFloat(4), -5458448.34f);
	}
	
	@Test
	void longTest() {
		ByteArray arr = ByteArray.create(16);
		arr.setLong(0, Integer.MAX_VALUE - 335);
		arr.setLong(8, Long.MAX_VALUE - 43);
		assertEquals(arr.getLong(0), Integer.MAX_VALUE - 335);
		assertEquals(arr.getLong(8), Long.MAX_VALUE - 43);
	}
	
	@Test
	void doubleTest() {
		ByteArray arr = ByteArray.create(16);
		arr.setDouble(0, 500.87364);
		arr.setDouble(8, 100.2674);
		assertEquals(arr.getDouble(0), 500.87364);
		assertEquals(arr.getDouble(8), 100.2674);
	}
}
