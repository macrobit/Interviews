/*********************************************************************************************************
 * 			Problem: Reverse Words
 * 			
 * 			Method: To solve this problem need a very important java library method String.split(String regex).
 * 					Regex is the symbol used to split a long string. Be careful, if you use " " as regex, between two
 * 					continuous space is a empty "". 
 * 					Example: there is a string "  a b  c d  "
 * 							after splitting this string with " ", we can get a string array.
 * 							"" "" "a" "b" "" "c" "d"
 * 							 0  1  2   3   4  5   6
 * 						
 * 
 * 			
 **********************************************************************************************************/

package reverse;

import java.lang.String;

public class ReverseWords {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) 
            return "";
        
        String[] words = s.split(" ");
        StringBuffer result = new StringBuffer();
        
        for(int i = words.length - 1; i >= 0; i--) {
            if(!words[i].isEmpty()) {
                result.append(words[i]);
                System.out.println("append '" + words[i] + "'");
            } 
            
            if(i-1 >= 0 && !words[i-1].isEmpty()) {
                result.append(' ');
                System.out.println("append a space");
            }
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
    	String input = "  a b ";
    	ReverseWords test = new ReverseWords();
    	String output = test.reverseWords(input);
    	System.out.println("'" + output + "'");
    }
}
