/**********************************************************************************
 * 
 * 			Problem: Find Minimum in Rotated Sorted Array
 * 			
 * 	Description: 1. A sorted array is rotated at some pivot (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 				 2. No duplicate in this array.
 * 
 *  	   Tags: binary search, inflection point
 *               /
 *              /
 *             /-------
 *                    /
 *                   /
 *                 $/           
 **********************************************************************************/


package array;

public class MinimumInRotatedSortedArray {
// method 1: find the first element which is less than its front element.
// Pros: also can handle duplicates.
	public int findMin(int[] nums) {
		int len = nums.length;
		for(int i = 1; i < len; i++) {
			if(nums[i] < nums[i - 1]) {
				return nums[i];
			}
		}
		// if len = 1 or a sorted array
		return nums[0];
	}
	
// method 2: If there is no duplicate, we can use binary search
	public int findMin2(int[] nums) {
		int len = nums.length;
		int start = 0, end = len - 1;
		while(start + 1 < end) {
			int mid = start + (end - start) / 2;
			if(nums[mid] > nums[start]) {
				start = mid;
			} else {
				end = mid;
			}
		}
		
		if(nums[start] > nums[end]) {
			return nums[end];
		} else {
			return nums[0];
		}
	}
}
