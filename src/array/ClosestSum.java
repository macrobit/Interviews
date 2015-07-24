package array;

//input array: 2, 4, 8, 10, 12
//target value: 17
//result: indices 1, 4 or 2, 3; return one of them is sufficient.

import java.lang.String;
import java.util.Arrays;

public class ClosestSum {
	public int[] getIndex(int[] array, int val) {
		int len = array.length;						
		int start = 0, end = len - 1;
		int diff = Integer.MAX_VALUE;
		int[] result = new int[2];
		int sum = 0;
		
		
		while(start < end) {
			sum = array[start] + array[end];
			
			if(Math.abs(sum - val) < diff) {
				diff = Math.abs(sum - val);
				result[0] = start;
				result[1] = end;
			}
			
			// minor adjustment!
			if(sum > val) {
				end--;
			} else {
				start++;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		ClosestSum test = new ClosestSum();
		int[] input = {2, 4, 8, 10, 12, 20};
		int[] output = test.getIndex(input, 17);
		System.out.println(Arrays.toString(input));
		System.out.println(Arrays.toString(output));
		
	}
	
}
