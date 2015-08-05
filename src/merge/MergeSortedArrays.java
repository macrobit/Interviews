package merge;
import java.util.Arrays;


public class MergeSortedArrays {
	// method 1: no extra space used, end -> head.
	public void merge(int[] nums1, int m, int[] nums2, int n){
		int i = m-1; int j = n-1; int k = m+n-1;
		while(i >= 0 && j >= 0){
			nums1[k--] = nums1[i] <= nums2[j] ? nums2[j--] : nums1[i--];
		}
		while(j >= 0){
			nums1[k--] = nums2[j--];
		}
	}
	
	public void merge2(int[] nums1, int m, int[] nums2, int n) {
		while(n > 0) 
			nums1[m+n-1] = ((m==0) || nums1[m-1] < nums2[n-1]) ? nums2[--n] : nums1[--m];
	}

	// method 2: use a new array to hold the result. head -> end
	public int[] merge3(int[] nums1, int m, int[] nums2, int n) {
		
	}
	public static void main(String[] args){
		int[] nums1 = new int[7];
		nums1[0] = 1;
		nums1[1] = 3;
		nums1[2] = 5;
		int[] nums2 = {4,5,6,7};
		MergeSortedArrays test = new MergeSortedArrays();
		test.merge2(nums1, 3, nums2, 4);
		System.out.println("" + Arrays.toString(nums1));
		
		
	}
}
