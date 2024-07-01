package abstractData;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InSetMainClass {

	public static void main(String[] args) throws IllegalArgumentException {
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
			
			
			InSet s1 = new InSet(array1);
			InSet s2 = new InSet(array2);
			while (true) {
				System.out.print("\n1.Chceking If Number is Present in Set \n2.Chceking for Subset \n3.Union of the Set \n4.Checking the size"+
						"\n5.Get Complement Function \n6.Printing the set");
				
				System.out.print("\nEnter Your Choice: ");
				int choice = sc.nextInt();
				System.out.println();
				switch (choice) {
				
				case 1:
					System.out.print("Enter number to check: ");
					int num = sc.nextInt();
					
					if (s1.isMember(num)) {
						System.out.println(num + " is a Member of S1");
					} else {
						System.out.println(num + " is not a Member S1");
					}
					
					if (s2.isMember(num)) {
						System.out.println(num + " is a Member of S2");
					} else {
						System.out.println(num + " is not a Member S2");
					}
					System.out.println();
					break;

				case 2:
					if (InSet.isSubSet(s2, s1)) {
						System.out.println("Yes, S1 is a Subset of S2");
					} else {
						System.out.println("No, S1 is not a Subset of S2");
					}
					if (InSet.isSubSet(s1, s2)) {
						System.out.println("Yes, S2 is Subset of S1");
					} else {
						System.out.println("No, S2 is not a Subset of S1");
					}
					System.out.println();
					break;
					
				case 3: 
					int arr[] = InSet.union(s1, s2);
					System.out.print("Union of Both set: ");
					for(int i: arr) {
						System.out.print(i+" ");
					}
					System.out.println();
					break;
					
				case 4:
					System.out.println("Size: " + s1.size());
					System.out.println("Size: " + s2.size());
					System.out.println();
					break;

				case 5:
					int[] s4 = s1.getComplement();
					System.out.print("Complement of S1: ");
					for (int value : s4) {
						System.out.print(value + " ");
					}
					System.out.println();
					
					int[] s5 = s2.getComplement();
					System.out.print("Complement of S2: ");
					for (int value : s5) {
						System.out.print(value + " ");
					}
					System.out.println();
					break;

				case 6:
					System.out.print("S1: ");
					InSet.printSet(s1);
					System.out.print("S2: ");
					InSet.printSet(s2);
					System.out.println();
					break;
					
				default:
					System.out.println("Enter correct choice");
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
