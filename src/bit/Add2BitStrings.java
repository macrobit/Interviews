/************************************************************************************************
 * 
 * 		Analysis: addition of two bit sequences a and b need to sum 3 bits, a, b, and carry.
 * 			1. When would the sum be 1?
 * 				The sum will be 1 if either all 3 bits are 1, or only one of them is 1.
 * 				The sum will be 0 if either all 3 bits are 0, or only two of them are 1.
 * 				OXR can be used to get the correct result:
 * 					sum = a OXR b OXR carry
 * 			2. When will the carry bit become 1?
 * 				Any two of them are 1.
 * 					carry = (a & b) | (b & c) | (a & c)
 * 				
 ***********************************************************************************************/

package bit;

import java.lang.Character;
import java.lang.StringBuffer;


public class Add2BitStrings {
	public String add(String a, String b) {
//		char[] a_array = a.toCharArray();
//		char[] b_array = b.toCharArray();
//		int len = a.length() > b.length() ? a.length() : b.length();
//		int[] c_array = new int[len + 1];
//		
//		int i = a.length() - 1, j = b.length() - 1, k = c_array.length - 1;
//		int carry_bit = 0;
//		while(i >= 0 && j >= 0) {
//			int a_bit = Character.getNumericValue(a_array[i]);
//			System.out.println("a: " + a_bit);
//			int b_bit = Character.getNumericValue(b_array[j]);
//			System.out.println("b: " + b_bit);
//			int sum = a_bit + b_bit + carry_bit;
//			
//			switch (sum) {
//				case 3: c_array[k] = 1;
//						carry_bit = 1;
//						break;
//				case 2: c_array[k] = 0;
//				        carry_bit = 1;
//				        break;
//				case 1: c_array[k] = 1;
//						carry_bit = 0;
//						break;
//				case 0: c_array[k] = 0;
//						carry_bit = 0;
//						break;
//			}	
//				
//			i--;
//			j--;
//			k--;
//		}
//
//		while(i >= 0) {
//			int a_bit = Character.getNumericValue(a_array[i]);
//			int sum = a_bit + carry_bit;
//			if(sum == 2) {
//				c_array[k] = 0;
//				carry_bit = 1;
//			} else {
//				c_array[k] = sum;
//				carry_bit = 0;
//			}
//			i--;
//			k--;
//		}
//		
//		while(j >= 0) {
//			int b_bit = Character.getNumericValue(b_array[j]);
//			int sum = b_bit + carry_bit;
//			if(sum == 2) {
//				c_array[k] = 0;
//				carry_bit = 1;
//			} else {
//				c_array[k] = sum;
//				carry_bit = 0;
//			}		
//			j--;
//			k--;
//		}
//		
//		StringBuffer output = new StringBuffer();
//		int index = c_array.length - 1;
//		while(index > 0) {
//			output.append(c_array[index]);
//		}
//		
//		if(c_array[0] != 0) {
//			output.append(1);
//		}
//		
//		return output.toString();
		
		int len = a.length() < b.length() ? b.length() + 1 : a.length() + 1;
		int[] aNum = new int[len];
		int[] bNum = new int[len];
		
		// initialize an integer array for string a
		for(int i = 0; i < len; i++) {
			if(i < len - a.length()) {
				aNum[i] = 0;
			} else {
				aNum[i] = Character.getNumericValue(a.charAt(i - len + a.length()));
			}
		}
		
		// initialize an integer array for string b
		for(int i = 0; i < len; i++) {
			if(i < len - b.length()) {
				bNum[i] = 0;
			} else {
				bNum[i] = Character.getNumericValue(b.charAt(i - len + b.length()));
			}
		}
		
		int carry = 0;
		for(int i = len - 1; i >= 0; i--) {
			int a_bit = aNum[i];
			int b_bit = bNum[i];
			
			aNum[i] = a_bit ^ b_bit ^ carry;
			
			carry = (a_bit & b_bit) | (b_bit & carry) | (a_bit & carry);
		}
		
		
		StringBuffer output = new StringBuffer();
		for(int i = 0; i < len; i++) {
			output.append(aNum[i]);
		}
		
		return output.toString();
	}
	
	public static void main(String[] args) {
		String a = "1100011";
		String b = "10";
		Add2BitStrings test = new Add2BitStrings();
		System.out.println(test.add(a, b));
		
	}
}
