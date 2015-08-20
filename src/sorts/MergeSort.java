/****************************************************************************************************
 * 				                        Merge Sort 
 * 
 * 	Introduction: Merge Sort is one of the earliest sorting algorithm. It was proposed by 
 * 				  John Von Neumann as early as 1945.
 * 
 *  Description: 3 steps
 * 				1. Divide the input array into two subarrays of roughly equal size.
 * 				2. Recursively merge sort each of the subarray.
 * 				3. Merge the newly-sorted subarrays into a single sorted array.
 * 
 *  Complexity analysis:
 *  			T(n) = 2T(n/2) + n;  O(nlog(n))
 *  
 ***************************************************************************************************/


package sorts;

import java.lang.Math;
import java.util.Arrays;

public class MergeSort {
	
	public void mergeSort(int[] A) {
		int[] buffer = new int[A.length];
		//mergeSort(A, buffer, 0, A.length-1);
		bottomUpMergeSort(A, buffer, A.length); // end is exclusive
	}

// Top-down
	private void mergeSort(int[] A, int[] buffer, int start, int end) { // end is inclusive
		if(start < end) {
			// find the median
			int median = start + (end - start) / 2;
		
			// recursively merge sort two subarrays
			mergeSort(A, buffer, start, median);
			mergeSort(A, buffer, median+1, end);
		
			// merge
			merge(A, buffer, start, median, end);
		}	
	}
	
	private void merge(int[] A, int[] B, int start, int mid, int end) {
		int i = start, j = mid + 1;
		for(int k = start; k <= end; k++) {
			if(j > end) { // right part clears
				B[k] = A[i++];
			} else if(i > mid) { // left part clears
				B[k] = A[j++];
			} else if(A[i] < A[j]) { // left < right
				B[k] = A[i++];
			} else { // left > right
				B[k] = A[j++];
			}
		}
		
		/*if(i <= mid && (j > end || A[i] < A[j])) {
		 * 		B[k] = A[i++];
		 * } else {
		 * 		B[k] = A[j++];
		 * }
		 */
		
		// copy B to A
		for(int k = start; k <= end; k++) {
			A[k] = B[k];
		}
	}
	
// Bottom-up
	private void bottomUpMerge(int[] A, int[] B, int left, int right, int end) {
		if(left > right || left > end || right > end)
			throw new IllegalArgumentException("Invalid arguments");
		
		int i = left, j = right;
		for(int k = left; k < end; k++) {
			if(i < right && (j >= end || A[i] < A[j])) {
				B[k] = A[i++];
			} else {
				B[k] = A[j++];
			}
		}
		
		//copy array
		for(int k = left; k < end; k++) {
			A[k] = B[k];
		}
		
	}
	
		
	public void bottomUpMergeSort(int[] A, int[] B, int n) {
		// if width >= n, the array is sorted already
		for (int width = 1; width < n; width *= 2) {
			for (int i = 0; i < n; i = i + 2 * width) {
				bottomUpMerge(A, B, i, Math.min(i + width, n), Math.min(i + 2 * width, n));
			}
		}
	}
	
	public static void main(String[] args) {
		int[] input = {3,5,1,2,4,19,15,16};
		MergeSort test = new MergeSort();
		test.mergeSort(input);
		System.out.println(Arrays.toString(input));
		
	}
}
