/*
 * There are three interval where the target may be located:
 * [S, M1], [M1, M2], [M2, E]
 * 
 * 
 *           .
 *         . | 
 *       M1  |
 *     .     |
 *   .       |
 * S -------------------E              
 *           |        .
 *           |      .
 *           |    .
 *           |  M2 
 *            .
 * 
 */

package binary;

public class SearchInRotatedArray {
// method 1: if there is no duplicate
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        int start = 0, end = len - 1;
        while(start + 1 < end) {
            int middle = start + (end - start) / 2;
            if(nums[middle] == nums[start]) {
                return true;
            }
            // middle in the left sorted array
            if(nums[middle] > nums[start]) {
                if(nums[middle] > target && nums[start] <= target) { // target in the left sorted array
                    end = middle;
                } else { // target in the right rotated array
                    start = middle;
                }
            }
            else { // middle in the right sorted array
               if(nums[middle] < target && nums[end] >= target) { // target in the right sorted array
                   start = middle;
               } else { // target in the left rotated array
                   end = middle;
               }
            }
        }
        
        return nums[start] == target || nums[end] == target ? true : false;
    }
    
// method 2: if there can be duplicates.
    public boolean search2(int[] nums, int target) {
    	int len = nums.length;
    	int start = 0, end = len - 1;
    	while(start + 1 < end) {
    		int mid = start + (end - start) / 2;
    		if(nums[mid] == target) 
    			return true;
    		else if(nums[start] == nums[mid]) 
    			start++;
    		else if(nums[end] == nums[mid]) 
    			end--;
    		else if(nums[start] <= target && nums[mid] >= target) 
    			end = mid;
    		else if(nums[mid] <= target && nums[end] >= target)
    			start = mid;
    		else if(nums[mid] < nums[start])
    			end = mid;
    		else if(nums[mid] > nums[start])
    			start = mid;    		
    	}
    	
    	return nums[start] == target || nums[end] == target ? true : false;
    }
}
