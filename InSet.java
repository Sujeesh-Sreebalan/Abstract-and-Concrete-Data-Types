package abstractData;
import java.util.ArrayList;
import java.util.Arrays;

final class InSet{

	private final int set[];
	
	/**
	 * Constructor of the class which arr as argument and also checks if array element are in range
	 * 
	 * @param arr input aray
	 * @throws IllegalArgumentException if element are outside the range
	 */
	public InSet(int arr[]) throws IllegalArgumentException{
		this.set = arr;
		for(int i = 0; i < arr.length ; i++){
			if(arr[i]<0 || arr[i]>1000)
				throw new IllegalArgumentException("Value out of range");
			set[i] = arr[i];
		}
	}
	
	/**
	 * Function to check if element is present in the array
	 * 
	 * @param x Input number to be checked in the array
	 * @return if number found return true else false
	 */
	public boolean isMember(int x) {
		for(int value: set) {
			if(value == x) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @return size of the array
	 */
	public int size() {
		return set.length;
	}
	
	/**
	 * function to check if given set is the subset of current set
	 * 
	 * @param subSet Inpput set 
	 * @return if given set is subset of current set then true else false
	 */
	public static boolean isSubSet(InSet set1, InSet set2) {
		int set1Length = set1.set.length;
		int set2Length = set2.set.length;
		
		if(set2Length > set1Length) {
			return false;
		}else {
			for(int index=0; index < set2Length; index++) {
				
				boolean flag=false;
				int value = set2.set[index];
				
				for(int j=0; j<set1Length; j++) {
					if(value == set1.set[j]) {
						flag = true;
					}
				}if(flag == false) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Function to return the complement of the universalSet[1-1000]
	 * 
	 * @return complement of set
	 */
	public int[] getComplement() {
		int universalSet[] = new int[1000 - set.length];
		int index = 0;
		
		for(int i=1; i<1000; i++) {
			boolean flag = false;
			for(int j=0; j<set.length; j++) {
				if(set[j] == i) {
					flag = true;
					break;
				}
			}if(!flag) {
				universalSet[index] = i;
				index++;
			}
		}
		
		return universalSet;
	}
	
	
	/**
	 * Funciton to find the union of both the set
	 * 
	 * @param set1 Input set
	 * @param set2 Input set
	 * @return union of both set
	 */
	public static int[] union(InSet set1, InSet set2) {
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i=0; i<set1.set.length; i++) {
			arr.add(set1.set[i]);
		}
		
		for(int i=0; i<set2.set.length; i++) {
			if(!arr.contains(set2.set[i])) {
				arr.add(set2.set[i]);
			}
		}
		
		int unionSet[] = new int[arr.size()];
		for(int i=0; i<unionSet.length; i++) {
			unionSet[i] = arr.get(i).intValue();
		}
		Arrays.sort(unionSet);
		return unionSet;
		 
	}
	
	/**
	 * Function to print the set
	 * 
	 * @param inputSet Input set
	 */
	public static void printSet(InSet inputSet){
		for(int value: inputSet.set){
			System.out.print(value+" ");
		}
		System.out.println();
	}
	
	
}
