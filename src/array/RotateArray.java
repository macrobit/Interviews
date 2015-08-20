package array;

import java.util.Arrays;

public class RotateArray {
// Method one: double the original array and use mod to calculate the step
  public void rotate1(int[] nums, int k) {
	  int len = nums.length;
	  int[] sum = new int[2*len];
	  int step = k % len;
 
  // Combine two integer arraies into one
	  for(int i=0; i<len; i++) {
		  sum[i] = nums[i];
		  sum[len+i] = nums[i];
	  }
 
	  for(int i=0; i<len; i++) {
		  nums[i] = sum[len-step+i];
  	  }
  }

// Method two: mod computing
  
  public void rotate2(int[] nums, int k) {
	  int len = nums.length;
	  int[] tmp = new int[len];
	  tmp = nums.clone();
   
	  for(int i=0; i<len; i++) {
		  int step = (i + k) % len;
		  nums[step] = tmp[i];
	  }
  }  
  
// Method three: ???????
  public void rotate3(int[] nums, int k) {
		if (nums.length == 0) return;
		int n = nums.length;
		while ((k %= n) > 0 && n > 1) {
			int range = n - k;
			for (int i = 1; i <= range; i++) {
				int tmp = nums[n - i];
				nums[n - i] = nums[n - i - k];
				nums[n - i - k] = tmp;
			}
			n = k;
			k = n - (range % k);
		}
	}

// Method 4: reverse in 3 steps
  public static void reverse(int[] nums) {
      
      int len = nums.length;
      for(int i = 0; i < len/2; i++) {
         int temp = nums[i];
         nums[i] = nums[len - 1 - i];
         nums[len - 1 - i] = temp;
      }
  }
  public void rotate(int[] nums, int k) {
      int len = nums.length;
      int step = k % len;
      if(step == 0) return;
      int[] left = Arrays.copyOfRange(nums, 0, len - step);
      int[] right = Arrays.copyOfRange(nums, len - step, len);
      reverse(left);
      reverse(right);
      System.arraycopy(left, 0, nums, 0, len - step);
      System.arraycopy(right, 0, nums, len - step, step);
      reverse(nums);
  }
  
}
