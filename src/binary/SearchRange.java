/***************************************************************************************
 * 		Problem: Search the range of a target value
 * 
 * 		Description: 
 * 			Given a sorted array of integers, find the starting and ending position of a given target value.
 *
 *			Your algorithm's runtime complexity must be in the order of O(log n).
 *
 *			If the target is not found in the array, return [-1, -1].
 *
 *			For example,
 *			Given [5, 7, 7, 8, 8, 10] and target value 8,
 *			return [3, 4].
 *
 *		Data Structure: array
 *
 *		Algorithm: Binary Search
 *
 *		Time complexity: O(log(n))
 *******************************************************************************************/


package binary;

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int start = 0, end = nums.length - 1;
        int mid = 0;
        
        // get the first target's position
        while(start + 1 < end) {
            mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                end = mid;
            } else if(nums[mid] < target) {
                start = mid;
            } else if(nums[mid] > target) {
                end = mid;
            }
        }
        
        if(nums[start] == target) {
            result[0] = start;
        }
        else if(nums[end] == target) {
            result[0] = end;
        } else {
            // if the first one doesn't exist, neither does the last one. 
        	// There is no need to run the left statements
            result[0] = result[1] = -1;
            return result;
        }

        // get the last target's position
        // don't forget reset these three variables
        start = 0;
        end = nums.length - 1;
        mid = 0;
        while(start + 1 < end) {
            mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                start = mid;
            } 
            else if(nums[mid] < target) {
                start = mid;
            } 
            else if(nums[mid] > target) {
                end = mid;
            }
        }
        
        if(nums[end] == target) {
            result[1] = end;
        }
        else if(nums[start] == target) {
            result[1] = start;
        }
        
        return result;
    }
}
