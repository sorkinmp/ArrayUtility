import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayUtilityTester {

	@Test
	public void testGetCurrentSize() {
		ArrayUtility au = new ArrayUtility();
		assertEquals(0, au.getCurrentSize());
		au.add(0);
		assertEquals(1, au.getCurrentSize());
		au.remove(0);
		assertEquals(0, au.getCurrentSize());
	}

	@Test
	public void testIsEmpty() {
		ArrayUtility au = new ArrayUtility();
		assertEquals(0, au.getCurrentSize());
		assertTrue(au.isEmpty());
		au.add(0);
		assertFalse(au.isEmpty());
		au.remove(0);
		assertTrue(au.isEmpty());
	}

	@Test
	public void testContains() {
		ArrayUtility au = new ArrayUtility();
		assertEquals(0,au.getCurrentSize());
		assertFalse(au.contains(1));
		au.add(1);
		assertTrue(au.contains(1));
		au.remove(1);
		assertFalse(au.contains(1));
	}

	@Test
	public void testGet() {
		ArrayUtility au = new ArrayUtility();
		assertEquals(0,au.getCurrentSize());
		assertEquals(null, au.get(0));
		for (int i = 0; i < au.getIntArray().length; i++) {
			au.add(i);
			assertTrue(au.get(i) == i);
		}
		assertTrue(au.removeLast());
		assertTrue(au.get(9) == null);
	}

	@Test
	public void testIndexOf() {
		ArrayUtility au = new ArrayUtility();
		assertEquals(-1, au.indexOf(5));
		assertTrue(au.add(5));
		assertEquals(0, au.indexOf(5));
		assertTrue(au.remove(5));
		assertEquals(-1, au.indexOf(5));
	}

	@Test
	public void testGetFrequencyOf() {
		ArrayUtility au = new ArrayUtility();
		assertEquals(0,  au.getFrequencyOf(2));
		assertTrue(au.add(2));
		assertEquals(1, au.getFrequencyOf(2));
		assertTrue(au.add(2));
		assertEquals(2, au.getFrequencyOf(2));
		assertTrue(au.remove(2));
		assertEquals(1, au.getFrequencyOf(2));
		assertTrue(au.remove(2));
		assertEquals(0, au.getFrequencyOf(2));
	}

	@Test
	public void testAddInteger() {
		ArrayUtility au = new ArrayUtility();
		for(int i = 1; i<11; i++) {
			au.add(i);
		}
		for(int i = 0; i<10; i++) {
			System.out.println(au.get(i));
		}
		assertTrue(au.get(0) == 1);
		assertTrue(au.get(9) == 10);
		assertTrue(au.getCurrentSize() == 10);
		assertFalse(au.getCurrentSize() == 0);
		assertFalse(au.isEmpty());

	}

	@Test
	public void testAddIntegerInt() {
		ArrayUtility au = new ArrayUtility();
		for(int i = 1; i<11; i++) {
			au.add(i);
		}
		for(int i = 0; i<10; i++) {
			System.out.println(au.get(i));
		}
		assertTrue(au.get(0) == 1);
		assertTrue(au.get(9) == 10);
		assertTrue(au.getCurrentSize() == 10 );
		assertFalse(au.getCurrentSize() == 0);
		assertFalse(au.isEmpty());
	}

	@Test
	public void testRemove() {
		ArrayUtility au = new ArrayUtility();
		au.add(100);
		au.add(100);
		assertTrue(au.getCurrentSize() == 2);
		au.remove(100);
		assertTrue(au.getCurrentSize() == 1);
		assertTrue(au.indexOf(100) == 0);
		au.add(50);
		au.add(40);
		au.add(30);
		au.remove(40);
		assertTrue(au.getCurrentSize() == 3);
		assertTrue(au.get(0) == 100);
		assertTrue(au.get(1) == 50);
		assertTrue(au.get(2) == 30);
	}

	@Test
	public void testRemoveFirst() {
		ArrayUtility au = new ArrayUtility();
		assertTrue(au.add(5));
		assertTrue(au.add(6));
		assertTrue(au.removeFirst());
		assertFalse(au.contains(5));
	}

	@Test
	public void testRemoveLast() {
		ArrayUtility au = new ArrayUtility();
		assertFalse(au.removeLast());
		assertTrue(au.add(5));
		assertTrue(au.add(6));
		assertTrue(au.add(7));
		assertTrue(au.removeLast());
		assertEquals(null, au.get(2));
	}

	@Test
	public void testRemoveMiddle() {
		ArrayUtility au = new ArrayUtility();
		au.add(1);
		au.add(2);
		au.add(3);
		assertTrue(au.getCurrentSize() == 3);
		au.removeMiddle();
		assertTrue(au.getCurrentSize() == 2);
		assertTrue(au.indexOf(2) == -1);
		assertTrue(au.indexOf(3) == 1);
		assertTrue(au.indexOf(1) == 0);
		for(int i = 0; i < au.getCurrentSize(); i++) {
			System.out.println(au.get(i));
		}
	}

	@Test
	public void testReverse() {
		ArrayUtility au = new ArrayUtility();
		ArrayUtility au2 = new ArrayUtility();
		assertTrue(au.add(5));
		assertTrue(au2.add(5));
		assertTrue(au.add(5));
		assertTrue(au2.add(5));
		au.reverse();
		assertTrue(au.get(1) == au2.get(0));
	}

	@Test
	public void testClear() {
		ArrayUtility au = new ArrayUtility();
		assertTrue(au.add(5));
		assertTrue(au.add(6));
		au.clear();
		assertEquals(0, au.getCurrentSize());
	}

}
