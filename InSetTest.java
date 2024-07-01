package abstractData;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class InSetTest {

	@Test
	public void testOutRange() {
		try {
			InSet setarray = new InSet(new int[] { -1, 1002 });
		} catch (Exception e) {
			assertEquals("Value out of range", e.getMessage());
		}
	}

	@Test
	public void testLength() throws IllegalArgumentException {
		InSet setarray = new InSet(new int[] { 6, 7, 8, 10 });
		int returnedValue = setarray.size();
		int expectedValue = 4;
		assertEquals(expectedValue, returnedValue);
	}

	@Test
	public void isMemberTest() throws IllegalArgumentException {
		InSet setarray = new InSet(new int[] { 1, 2, 3, 4, 5 });
		assertTrue(setarray.isMember(4));
	}

	// negative test case to check if the number is member of set
	@Test
	public void isMemberTest1() throws IllegalArgumentException {
		InSet setarray = new InSet(new int[] { 1, 2, 3, 4, 5 });
		assertFalse(setarray.isMember(8));
	}

	// positive test to check if given array is a subset
	@Test
	public void subsetTest() throws IllegalArgumentException {
		InSet setarray = new InSet(new int[] { 1, 2, 3, 4, 5 });
		InSet subsetarray = new InSet(new int[] { 1, 2, 3 });
		assertTrue(InSet.isSubSet(setarray, subsetarray));
	}

	// negative test to check if given array is a subset
	@Test
	public void subsetTest1() throws IllegalArgumentException {
		InSet setarray = new InSet(new int[] { 1, 2, 3, 4, 5 });
		InSet subsetarray = new InSet(new int[] { 7, 8 });
		assertFalse(InSet.isSubSet(setarray, subsetarray));
	}

	// test to check if null set is a subset
	@Test
	public void subsetTest2() throws IllegalArgumentException {
		InSet setarray = new InSet(new int[] { 1, 2, 3, 4, 5 });
		InSet subsetarray = new InSet(new int[] {});
		assertTrue(InSet.isSubSet(setarray, subsetarray));
	}

	@Test
	public void unionTest() throws IllegalArgumentException {
		InSet setarray1 = new InSet(new int[] { 1, 2, 3 });
		InSet setarray2 = new InSet(new int[] { 4, 5, 6 });
		int returnedArrOperation[] = InSet.union(setarray1, setarray2);
		int[] expectedArr = new int[] { 1, 2, 3, 4, 5, 6 };
		assertArrayEquals(expectedArr, returnedArrOperation);
	}

	@Test
	public void unionTest1() throws IllegalArgumentException {
		InSet setarray1 = new InSet(new int[] { 1, 2, 3 });
		InSet setarray2 = new InSet(new int[] { 2, 3, 5, 6 });
		int returnedArrOperation[] = InSet.union(setarray1, setarray2);
		int[] expectedArr = new int[] { 1, 2, 3, 5, 6 };
		assertArrayEquals(expectedArr, returnedArrOperation);
	}

}
