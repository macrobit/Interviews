package leetCode;
/*What are isomorphic strings?
Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurrence of a character must be replaced with the same character which may be itself.
The mapping relation must be one to one.
For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.*/
import java.util.HashMap;

public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		if(s.length() != t.length()) return false;
		int len = s.length();
		HashMap<Character,Character> map = new HashMap<>();
		int index = 0;
		while(index < len) {
			char sCur = s.charAt(index);
			char tCur = t.charAt(index);
			if(map.containsKey(sCur) && map.get(sCur)!= tCur)
				return false;
			if(!map.containsKey(sCur) && map.containsValue(tCur))
				return false;
			map.put(sCur,tCur);
			index++;
		}
		return true;		
	}
	
	public static void main(String[] args){
		String s = "papers";
		String t = "titlee";
		IsomorphicStrings test = new IsomorphicStrings();
		System.out.println(test.isIsomorphic(s,t));
	}
}
