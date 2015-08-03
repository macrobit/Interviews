/*******************************************************************************************************
 * 			Problem 1: Search a 2D Matrix , return the occurrence of a value.
 * 					   This matrix has the following properties:
 * 						-- Integers in each row are sorted from left to right
 * 						-- Integers in each column are sorted from top to bottom
 * 						-- No duplicate integers in each row or column.
 * 
 * 			URL: lintcode.com/en/problem/search-a-2d-matrix-ii/
 * 
 * 			Challenge: O(m+n) time and O(1) extra space
 * 			
 * 
 *********************************************************************************************************/



package binary;

public class Search2DMatrix2 {

/* method 1: Quadrate Search
 * for a matrix satisfying the properties, the lower right corner value must be 
 * the largest value in this matrix.
 * 
 */
	
/* method 2: Dynamic Programming
 * If one value is smaller than target move right, else move up.
 * 
 *      if a < target, a---->; if a > target, a /\; if a == target, count++
 *      
 */
	
// method 3
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0) {
			return false;
		}
		if(matrix[0] == null || matrix[0].length == 0) {
			return false;
		}
		
		int row = matrix.length, column = matrix[0].length;
		int i = row - 1, j = 0;
		while(i >= 0 && j < column) {
			if(matrix[i][j] == target) {
				return true;
			} else if(matrix[i][j] < target) {
			// all the above elements in the column are excluded, move right
				j++;
			} else if(matrix[i][j] > target) {
			// all the right elements in the row are excluded, move up
				i--;
			}
		}
		
		return false;
	}
	
	
}
