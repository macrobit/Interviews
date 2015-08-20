/******************************************************************************************
 * 			Given a unsorted array, find its median in linear time.
 * 			
 * 			
 * 			
 *  Follow up: give a method to find Kth largest element in a unsorted array.
 *******************************************************************************************/

package median;

public class KthLargestElement {
	public int quickSelect(int[] nums, int start, int end, int k) {
		if(start > end)
			throw new IllegalArgumentException("start <= end");
		
		if(start == end) {
			return nums[start];	
		}
		else {
			int r = partition(nums, start, end);
			if(k < r) 
				quickSelect(nums, start, r-1, k);
			else if(k > r)
				quickSelect(nums, r+1, end, k-r);
			else
				return nums[r];
		} 	
		
		return 0;
	}
	
	private int partition(int[] A, int start, int end) {
		// select the pivot
		int p = end;
		
		// move pivot to the end
		if(p != end) {
			swap(A, p, end);
		}
		
		int i = start - 1, j = end;
		int pivot = A[p];
		while(i < j) {
			do {
				i++; 
			} while(i != j && A[i] < pivot);
			
			do {
				j--;
			} while(i != j && A[j] > pivot);
			
			if(i < j) {
				swap(A, i, j);
			}			
		}
		
		if(i != end) {
			swap(A, i, end);
		}
		
		return i;
	}
	
	private void swap(int[] A, int left, int right) {
		int temp = A[left];
		A[left] = A[right];
		A[right] = temp;
	}
}
