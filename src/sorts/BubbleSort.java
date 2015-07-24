package sorts;

import java.util.Arrays;

public class BubbleSort {
	public int[] sort(int[] a){
		int len = a.length;
		boolean swap = true;
		while(swap) {
			swap = false;
			int newlen = 0; //store the position of last swap
			for(int i = 0; i < len-1; i++) {
				if(a[i] > a[i+1]){
					int tmp = a[i];
					a[i] = a[i+1];
					a[i+1] = tmp;
					swap = true;
					newlen = i+1; //store the position of swap
				} else {}
			}
			len = newlen;
		}
		return a;

	}
	
	public static void main(String[] args) {
		BubbleSort test = new BubbleSort();
		int[] input = {8,1,5,3,2,5,4};
		int[] output = test.sort(input);
		System.out.println("" + Arrays.toString(output));
	}
}
