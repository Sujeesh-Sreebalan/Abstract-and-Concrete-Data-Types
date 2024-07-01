package abstractData;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PolyMainClass {

	public static void main(String[] args) throws IllegalArgumentException{
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("Enter size of First array: ");
			int size1 = sc.nextInt();
			int array1[] = new int[size1];
			for (int i = 0; i < size1; i++) {
				System.out.print("Enter the element: ");
				array1[i] = sc.nextInt();
			}
			
			System.out.print("\nEnter size of Second array: ");
			int size2 = sc.nextInt();
			int array2[] = new int[size2];
			for (int i = 0; i < size2; i++) {
				System.out.print("Enter the element: ");
				array2[i] = sc.nextInt();
			}
			
			Poly p1 = new Poly(array1);
			Poly p2 = new Poly(array2);
			
			while(true) {
				System.out.println("\n1.Evaluate the eqaution \n2.Calculate Degree \n3.Addition of Two Equation "
						+ "\n4.Multiplication of Two Equation \n5.Print Polynomial");
				
				System.out.print("Enter your choice: ");
				int choice = sc.nextInt();
				System.out.println();
				switch(choice) {
				case 1:
					System.out.print("Enter the value to evaluate the equation: ");
					int value = sc.nextInt();
					System.out.printf("\nValue of P1: %.2f",p1.evaluate(value));
					System.out.printf("\nValue of P1: %.2f",p2.evaluate(value));
					System.out.println();
					break;
					
				case 2:
					System.out.println("Degree of P1 "+p1.degree());
					System.out.println("Degree of P1 "+p2.degree());
					System.out.println();
					break;
					
				case 3:
					int sum[] = Poly.addPoly(p1, p2);
					System.out.print("Adddtion of Both equations: ");
					for(int i=0; i<sum.length; i++) {
						System.out.print(sum[i]+" ");
					}
					System.out.println();
					break;
					
				case 4:
					int product[] = Poly.multiply(p1, p2);
					System.out.print("Multiplication of Both equations: ");
					for(int i=0; i<product.length; i++) {
						System.out.print(product[i]+" ");
					}
					System.out.println();
					break;
					
				case 5:
					System.out.print("First Equation: ");
					p1.print();
					System.out.print("Second Equation: ");
					p2.print();
					System.out.println();
					break;
					
				default:
					System.out.print("Enter Correct Choice");
				}
			}
			
		}catch(AssertionError e) {
			System.err.println("Enter Valid Size");
		}catch(InputMismatchException e) {
			System.err.println("Error Occur "+e.getMessage());
		}finally {
			sc.close();
		}

	}

}
