/*****************************************************************************************************************
For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n) time complexity.

If the target number does not exist in the array, return -1.

Example
If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.

Challenge
If the count of numbers is bigger than 2^32, can your code work properly?
******************************************************************************************************************/

package binary;

public class BinarySearch {
	public int binarySearch(int[] array, int target) {
		int start, middle, end;
		start = middle = 0;
		end = array.length - 1;
		
		while(start + 1 < end) { // there is at least one element between start and end
			middle = start + (end - start) / 2;
			if(array[middle] == target) {
				
				/* Why don't directly return middle?
				 * Be careful! What we want is the first position of
				 * the target, however the middle one may not be the 
				 * first appearance of the target. We have to check
				 * all the elements in front of it.*/
				end = middle; // if the target is the last position, start = middle
			} else if(array[middle] < target) {
				start = middle; // or middle + 1
			} else {
				end = middle; // or middle - 1
			}
		}
		
		if(array[start] == target) return start; // if the target is the last position,
		if(array[end] == target) return end;     // these two statements exchange their positions.
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] input = {0,2,4,5,6,8,9};
		int target = 6;
		BinarySearch test = new BinarySearch();
		int output = test.binarySearch(input,target);
		System.out.println("The middle element's index is: " + output);
	}
}
