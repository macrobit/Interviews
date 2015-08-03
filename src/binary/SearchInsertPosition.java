/***********************************************************************************************************
 * 		Problem: Search Insert Position
 * 
 * 		URL: https://leetcode.com/problems/search-insert-position/
 * 
 * 		Description: 
 * 		Given a sorted array and a target value, return the index if the target is found. If not, 
 * 		return the index where it would be if it were inserted in order.
 *	 	You may assume no duplicates in the array.
 *		Here are few examples.
 *		[1,3,5,6], 5 ¡ú 2
 *		[1,3,5,6], 2 ¡ú 1
 * 		[1,3,5,6], 7 ¡ú 4
 * 		[1,3,5,6], 0 ¡ú 0
 * 
 * 		Algorithm: Binary Search
 * 
 ***********************************************************************************************************/

package binary;

public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
		int start = 0, end = nums.length - 1;
		
		while(start + 1 < end) {
			int mid = start + (end - start) / 2;
			if(nums[mid] == target) {
				return mid;
			} else if(nums[mid] > target) {
				end = mid;
			} else if(nums[mid] < target) {
				start = mid;
			}			
		}
		
		/* how to fix the position?
		 * find the first element >= target, this element's
		 * position is just what we need.
		 */
		if(nums[start] >= target) {
			return start;
		} else if(nums[end] >= target) {
			return end;
		} else {
			return nums.length + 1;
		}
	}
}
