/*********************************************************************************************************
 * 			Problem: Median of Two Sorted Arrays
 * 
 * 			Methods: 1. merge two sorted arrays k times. O(K)
 * 					 2. Binary search. O(log(k))
 * 
 *********************************************************************************************************/

package array;

import java.lang.Integer;

public class MedianTwoSortedArrays {

    public double findMedianSortedArrays(int A[], int B[]) {
        int len = A.length + B.length;
        if (len % 2 == 0) {
            return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2.0 ;
        } else {
            return findKth(A, 0, B, 0, len / 2 + 1);
        }
    }

	public static int findKth(int[] A, int A_start, int[] B, int B_start, int k) {
		// don't forget '='. The maximum index in an array is length-1!
		if(A_start >= A.length)
			return B[B_start + k - 1];
		if(B_start >= B.length)
			return A[A_start + k - 1];
		
		if(k == 1)
			return A[A_start] > B[B_start] ? A[A_start] : B[B_start];
			
		int A_key = A_start + k - 1 < A.length
					? A[A_start + k - 1]
					: Integer.MAX_VALUE;
		int B_key = B_start + k - 1 < B.length
					? B[B_start + k - 1]
					: Integer.MAX_VALUE;
		
		if(A_key < B_key) 
			A_start += k;
		else
			B_start += k;
		
		return findKth(A, A_start, B, B_start, k - k/2);
		
	}
}
