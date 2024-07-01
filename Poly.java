package abstractData;

final class Poly {
	final int equation[][];
	
	/**
	 * Constructorof the class which takes arr and checking the highst degress
	 * 
	 * @param poly Input array
	 * @throws Exception if size is zero or less then Exception is thrown
	 */
	public Poly(int poly[]) throws IllegalArgumentException {
		if (poly.length == 0) {
			throw new IllegalArgumentException("Empty Polynomial");
		}
		int count = 0;
		// counting non zero cofficient
		for (int i = 0; i < poly.length; i++) {
			if (poly[i] != 0) {
				count++;
			}
		}
		equation = new int[count][2];
		count = 0;

		for (int i = 0; i < poly.length; i++) {
			if (poly[i] != 0) {
				// degree
				equation[count][0] = i;
				// cofficient
				equation[count][1] = poly[i];
				count++;
			}
		}
	}

	/**
	 * Funciton to evaluate the eqaution at a given point
	 * 
	 * @param valueOfX Input value for which value is calculated
	 * @return value of the equation
	 */
	public float evaluate(float valueOfX) {
		// evalute 4x+3 at x=2;
		float value = 0;
		for (int i = 0; i < equation.length; i++) {
			value += Math.pow(valueOfX, equation[i][0]) * equation[i][1];
		}
		return value;
	}

	/**
	 * Function to calculate the degree
	 * 
	 * @return the highest degree in the equation
	 */
	public int degree() {
		return equation[equation.length - 1][0];

	}

	/**
	 * Function to get the degree of given input
	 * 
	 * @param index input value
	 * @return the degree 
	 */
	private int getIndex(int index) {
		int x = -1;
		for (int i = 0; i < equation.length; i++) {
			if (equation[i][0] == index) {
				x = equation[i][0];
			}
		}
		return x;
	}
	
	/**
	 * Function to get the cofficient of the given input
	 * 
	 * @param element Input value
	 * @return the cofficient
	 */
	private int getValueOf(int element) {
		int x = -1;
		for (int i = 0; i < equation.length; i++) {
			if (equation[i][0] == element) {
				x = equation[i][1];
			}
		}
		return x;
	}

	/**
	 * Function for the addition of two polynomial eqautions
	 * 
	 * @param p1 input polynomial 
	 * @param p2 input polynomial 
	 * @return the addition of both equation
	 */
	public static int[] addPoly(Poly p1, Poly p2) {
		int maxDegree = p1.degree() > p2.degree() ? p1.degree() + 1 : p2.degree() + 1;
		int sum[] = new int[maxDegree];

		for (int i = 0; i < maxDegree; i++) {
			if (p1.getIndex(i) == p2.getIndex(i)) {
				sum[i] = p1.getValueOf(i) + p2.getValueOf(i);
			} else if (-1 == p2.getIndex(i)) {
				sum[i] = p1.getValueOf(i);
			} else if (-1 == p1.getIndex(i)) {
				sum[i] = p2.getValueOf(i);
			} else {
				sum[i] = 0;
			}
		}
		return sum;
	}

	/**
	 * Function for the multiplication of two polynomial eqaution
	 * 
	 * @param p1 input polynomial 
	 * @param p2 input polynomial 
	 * @return the multiplication of both eqaution
	 */
	public static int[] multiply(Poly p1, Poly p2) {
		// (ax+b)(cx+d) = acx^2 + (bc+ad)x + bd
		int maxDegree = (p1.degree() * p2.degree()) + 1;
		int product[] = new int[maxDegree];

		for (int i = 0; i <= p1.degree(); i++) {
			for (int j = 0; j <= p2.degree(); j++) {
				if (p1.getIndex(i) > -1 && p2.getIndex(j) > -1) {
					product[p1.getIndex(i) + p2.getIndex(j)] += p1.getValueOf(i) * p2.getValueOf(j);
				}
			}
		}
		return product;
	}
	
	void print(){
		int i = 0;
		for(i = equation.length-1 ; i >= 0 ; i--){
			if(equation[i][0] == 0)
				System.out.print(equation[i][1] + " ");
			else
				System.out.print(equation[i][1] + "X^" + equation[i][0]);

			if(i == 0)
				continue;
			else
				System.out.print(" + ");
		}
		System.out.println("  ");
	}
}
