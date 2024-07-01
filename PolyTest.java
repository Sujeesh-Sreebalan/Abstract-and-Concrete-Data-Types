package abstractData;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PolyTest {

	@Test
	public void test_Empty_Array() {
		try {
			new Poly(new int[] {});
		} catch (Exception e) {
			assertEquals("Empty Polynomial", e.getMessage());
		}
	}

	// positive test case for evaluation of Polynomial
	@Test
	public void test_Evaluate_Positive() throws Exception {
		assertEquals(73.00, new Poly(new int[] { 1, 0, 2, 0, 4 }).evaluate(2), 0.0f);
	}

	// test case for finding degree of polynomial
	@Test
	public void test_Degree_Positive() throws Exception {
		assertEquals(3, new Poly(new int[] { 0, 1, 0, 5 }).degree());
	}

	@Test
	public void test_Add_Polyinomial() throws Exception {
		new Poly(new int[] { 1, 0, 2, 0, 4 });
		int returnedArrOperation[] = Poly
				.addPoly(new Poly(new int[] { 1, 0, 2, 0, 4 }), new Poly(new int[] { 0, 1, 0, 5 }));
		int[] expectedArr = new int[] { 1, 1, 2, 5, 4 };
		assertArrayEquals(expectedArr, returnedArrOperation);
	}

	@Test
	public void test_Multiply_Polyinomial() throws Exception {
		new Poly(new int[] { 1, 0, 2, 0, 4 });
		int returnedArrOperation[] = Poly
				.multiply(new Poly(new int[] { 1, 0, 2, 0, 4 }), new Poly(new int[] { 0, 1, 0, 5 }));
		int[] expectedArr = new int[] { 0, 1, 0, 7, 0, 14, 0, 20, 0, 0, 0, 0, 0 };
		assertArrayEquals(expectedArr, returnedArrOperation);
	}

}
