/*************************************************************************************
 * 		Problem: Find Peak Element
 * 		    URL: https://leetcode.com/problems/find-peak-element/
 * 
 * 	Description: A peak element is an element that is greater than its neighbors.
 * 				num[i] != num[i+1] (the adjacent two elements cannot equal)
 * 				There may be multiple peaks, return any of them is fine.
 * 				num[-1] and num[n] are regarded infinite small.
 * 	
 * 
 *************************************************************************************/

package array;

public class PeakElement {

	// method 1: O(n) complexity
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if(nums == null || len == 0) {
            return -1;
        }
        
        // one element
        if(len == 1) return 0;
        // two elements
        if(len == 2) {
            if(nums[0] < nums[1]) {
                return 1;
            } else {
                return 0;
            }
        }
        // more than two elements
        if(nums[0] > nums[1]) {
            return 0;
        } 
        if(nums[len - 2] < nums[len - 1]) {
            return len-1;
        }
        for(int i = 1; i < len - 1; i++) {
            if(nums[i-1] < nums[i] && nums[i] > nums[i+1]) {
                return i;
            }
        }
        
        return -1;
    }
    
    // method 2: concise version of method 1; compare 2n times; complexity O(n)
    
    public int findPeakElement2(int[] nums) {
    	int len = nums.length;
    	for(int i = 0; i < len; i++) {
    		boolean isleft = true; // bigger than left element
    		boolean isright = true; // bigger than right element
    		if(i > 0) isleft = nums[i] > nums[i - 1] ? true : false; // not the first element
    		if(i <= len - 2) isright = nums[i] > nums[i + 1] ? true : false; // not the last element
    		if(isleft && isright) return i;
    	}
    	return -1;
    }
    
    // method 3: O(n) compare n times
    // The idea is to find the inflection point of a curve
    public int findPeakElement3(int[] nums) {
    	int len = nums.length;
    	for(int i = 1; i < len; i++) { // imply that len > 1
    		if(nums[i] < nums[i - 1]) {
    			return i - 1;
    		}
    	}
    	return len - 1; // if len <= 1, return 0 or -1
    }
    
    
    // method 5: O(log n ) complexity: use binary search
    /* find the middle element, and compare it with its neighbors:
     * 1. middle < middle - 1 : a peak appears in the left.
     * 2. middle > middle - 1 && middle < middle + 1 : a peak appears in the right
     * 3. middle > middle - 1 && middle > middle + 1 : middle is the peak
     */
    public int findPeakElement5(int[] nums) {
    	int len = nums.length;
    	int start = 0, end = len - 1;
    	while(start + 1 < end) { // exclude the one element and two elements situation
    		int mid = start + (end - start) / 2;
    		if(nums[mid] < nums[mid - 1]) {
    			end = mid;
    		} else if(nums[mid] < nums[mid + 1]) {
    			start = mid;
    		} else if(nums[mid] > nums[mid + 1]) {
    			return mid;
    		}
    	}
    	
    	if(nums[start] > nums[end]) {
    		return start;
    	} else {
    		return end;
    	}
    }
}
