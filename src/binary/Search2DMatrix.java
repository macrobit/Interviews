/******************************************************************************************
 * 
 * 
 * 		Time Complexity: method 1  O(log(m*n)) 
 * 						 method 2  O(log(m) + log(n))
 * 
 * 
 *******************************************************************************************/
package binary;

import java.util.Arrays;

public class Search2DMatrix {
	
// method 1: use one binary search
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int length = m * n;
        int[] nums = new int[length];
        
//        for(int i = 0; i < m; i++) {
//            for(int j = 0; j < n; j++) {
//                nums[i*n+j] = matrix[i][j];
//            }
//        }
        
        System.out.println(Arrays.toString(nums));
        
        int start = 0, end = length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            int x = mid / n, y = mid % n;
            if(matrix[x][y] == target) {
                return true;
            } else if(matrix[x][y] > target) {
                end = mid;
            } else if(matrix[x][y] < target) {
                start = mid;
            }
        }
        
        if(matrix[start/n][start%n] == target) return true;
        if(matrix[end/n][end%n] == target) return true;
            
        return false;
        
    }
    
// method 2: use two binary search
    public boolean searchMatrix2(int[][] matrix, int target) {
    	// no entries in the first dimension
    	if(matrix == null || matrix.length == 0) {
    		return false;
    	}
    	// there are pointers in the first dimension, but all pointers point to nothing
    	if(matrix[0] == null || matrix[0].length == 0) {
    		return false;
    	}
    	
    	int row = matrix.length, column = matrix[0].length;
    	
    	// first binary search
    	int start = 0, end = row - 1;
    	while(start + 1 < end) {
    		int mid = start + (end - start) / 2;
    		int number = matrix[mid][0];
    		if(number == target) {
    			return true;
    		} else if(number > target) {
    			end = mid;
    		} else if(number < target) {
    			start = mid;
    		}
    	}
    	
//    	if(matrix[end][0] > target) {
//    		row = start;
//    	} else if(matrix[end][0] == target) {
//    		return true;
//    	} else {
//    		row = end;
//    	}
    	
    	if(matrix[end][0] <= target) {
    		row = end;
    	} else if(matrix[start][0] <= target) {
    		row = start;
    	} else {
    		return false;
    	}
    	
    	// second binary search
    	start = 0;
    	end = column - 1;
    	while(start + 1 < end) {
    		int mid = start + (end - start) / 2;
    		int number = matrix[row][mid];
    		if(number == target) {
    			return true;
    		} else if(number > target) {
    			end = mid;
    		} else if(number < target) {
    			start = mid;
    		}
    	}
    	
    	if(matrix[row][start] == target) return true;
    	if(matrix[row][end] == target) return true;
    	
    	return false;
    }
    
    public static void main(String[] args) {
    	int[][] input = { 
    			{1},
    			{5}
    	};
    	
    	Search2DMatrix test = new Search2DMatrix();
    	test.searchMatrix(input, 5);
    	
    }
}
