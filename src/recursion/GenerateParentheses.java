package recursion;

import java.util.ArrayList;

public class GenerateParentheses {
	    public ArrayList<String> generateParenthesis(int n) {
	        ArrayList<String> rst = new ArrayList<String>();
	        if(n <= 0) {
	            return rst;
	        }
	        getPair(rst, "", n, n);
	        return rst;
	    }
	    
		public void getPair( ArrayList<String> rst , String s, int left, int right) {
			if(left > right || left < 0 || right < 0) {
				return; 	
			}
			if(left == 0 && right == 0) {
				rst.add(s);
				return;
			}

			getPair(rst, s + "(", left - 1, right);
			getPair(rst, s + ")", left, right - 1);
		}
	
	public static void main(String[] args) {
		int n = 3;
		GenerateParentheses test = new GenerateParentheses();
		ArrayList<String> output = test.generateParenthesis(n);
		for(int i = 0; i < output.size(); i++) {
			System.out.println("" + output.get(i));
		}		
	}
}
