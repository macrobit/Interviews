/*
 *  
 *  Introduction: QuickSort method is a recursion method whose amortized time complexity is O(n log(n)). 
 *  			  It was discovered by Tony Hoare in 1962.
 *    
 *  Idea: The hard work is splitting the array into subsets so that merging the final result is trivial 
 *     		1. Choose a pivot element from the array.
 *     		2. Partition the array into three subarrays containing the elements smaller than the pivot, 
 *  		   the pivot element itself, and the elements larger than the pivot.
 *  		3. Recursively quicksort the first and last subarrays.
 *  
 * 	Example:
 * 		2 1 6 2 4 5 3 
 *  always use the last element as a pivot.
 *  
 *  Step 1: Use 3 as pivot. Left start point is 2, right start point is 5.
 *  	   Find the first 6 > 3 from left and the first 2 < 3 from right.
 *  	   6 is on the left of 2, swap them:
 *  		 	2 1 2 6 4 5 3
 *  	   when i++, i == j == 3. swap(6, 3)
 *  			2 1 2 3 4 5 6
 *  Step 2: quicksort left part 2 1 2 and right part 4 5 6
 * 
 *  Time Complexity: T(n) = T(result - 1) + T(n - result) + O(n)
 *  				If we could choose the median as a pivot, result = n/2, then two subproblems would be close
 *  				to the same size. T(n) <= 2T(n/2) + O(n)  :  O(nlogn).
 *  				If we just choose the first or last element, the worst case would use time O(n^2).
 */

package sorts;

import java.util.Arrays;
import java.lang.String;

public class QuickSort {
	public void quickSort(int[] A, int start, int end) {
		if(A == null || A.length == 0 || start >= end) 
			return ;
		
		// start must be less than end

		int result = partition(A, start, end);
		quickSort(A, start, result - 1);
		quickSort(A, result + 1, end);
	}
	
	// partition subroutine return the pivot position after sorting the original array.
	private int partition(int[] nums, int start, int end) {
		
		int p = end; // can set a random pivot
		// int p = selectPivot(A);

		
		// if it is a random pivot, move the pivot to the end
		if(end != p) {
			swap(nums, end, p);
		}
		
		int i = start - 1, j = end;
		int pivot = nums[end];

		while(true) {
			// Find the first greater one from left
			do {
				i++;  
			} while(i != j && nums[i] < pivot);
			
			// Find the first smaller one from right
			do {
				j--;
			} while(i != j && nums[j] > pivot);
			
			if(i >= j)
				break;
			
			// Swap
			swap(nums, i, j);						
		}
		
		// move pivot back to where it should be
		// Because i move first, when loop stops, nums[i] must be >= pivot, or to the end.
		if(i != end) { // if i == end, this array has already been sorted.
			swap(nums, i, end);
		}
		
		return i;
			
	}
	
	private void swap(int[] A, int i, int j) {
		if (i >= A.length || j >= A.length) {
			throw new IllegalArgumentException("index i and j must be in the range of A");
		}
		
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	private int selectPivot(int[] A) {
		return (int)Math.random() * A.length;
	}
	
	public static void main(String[] args) {
		int[] input = {4, 2, 3, 1, 5, 6, 3};
		QuickSort test = new QuickSort();
		test.quickSort(input, 0, input.length-1);
		System.out.println(Arrays.toString(input));
	}
	
}
