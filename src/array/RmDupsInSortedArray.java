/****************************************************************************************************
 * 		    Problem: Remove Duplicate in Sorted Array
 * 		Description: remove duplicates, each number only appear once. After removing, the order of 
 * 					 elements does not change. No extra space!
 * 
 * 
 ****************************************************************************************************/

package array;

public class RmDupsInSortedArray {
	public int removeDuplicates(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		
		// we need two indexes 
		int size = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[size] != nums[i]) {
				nums[++size] = nums[i];
			}
		}
		
		return size + 1;
	}
	
// Follow up: duplicates allowed at most twice
	public int removeDuplicates2(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		
		// count is used to count the number of duplicates
		// max is the max duplicates allowed
		int size = 0, count = 0, max = 2;
		for(int i = 0; i < nums.length; i++) {
			if(nums[size] != nums[i]) {
				nums[++size] = nums[i];
				count = 1;
			} 
			else {
				if(count > 0 && count < max) {
					nums[++size] = nums[i];
				}
				count++;
			}
		}
		
		return size + 1;
	}
	
/************************************************************************
 * Demo:
 * 
 *         1   1   1   1   3   3
 *        cur
 *        i,j
 *                   |
 *                   V
 *         1   1   1   1   3   3
 *   	   i  cur
 *             j
 *                   |       
 * 					 V
 * 		   1   1   1   1   3   3
 *                cur
 *         i       j
 *           		 |
 *           	     V
 *         1   1   1   1   3   3
 *    	   i      cur      j   
 *         			 |
 *                   V
 *         1   1   3   1   3   3
 *                    cur i,j
 *                  
 **************************************************************************/
	
	public int removeDuplicates3(int[] nums) {
		if(nums == null) return 0;
		
		int cur = 0; // the final result index
		int i, j; // i for comparison, j for runner
		for(i = 0; i < nums.length; ) {
			int now = nums[i];
			for(j = i; j < nums.length; j++) {
				// different element
				if(nums[j] != now) {
					break;
				}
				// duplicates
				if(j - i < 2) {
					nums[cur++] = now;
				}
			}
			
			i = j; // update index i
		}
		
		return cur;
	}
}
