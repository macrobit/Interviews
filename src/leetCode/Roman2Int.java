package leetCode;
import java.util.HashMap;

public class Roman2Int {
	private HashMap<Character, Integer> map = new HashMap<>();
	
	public Roman2Int() {
		map.put('I',1);
		map.put('V',5);
		map.put('X',10);
		map.put('L',50);
		map.put('C',100);
		map.put('D',500);
		map.put('M',1000);
	}
	public int romToInt(String s){
		int len = s.length();
		int rst = 0;
		int index = 0;
		while(index < len) {
			Character chCur = s.charAt(index);
			Character chNxt = null;
			if(index+1 < len)
				chNxt = s.charAt(index+1);
			if(chNxt != null && map.get(chCur) < map.get(chNxt))
				rst -= map.get(chCur);
			else 
				rst += map.get(chCur);
			index++;
		}
		if(rst > 0 && rst < 4000)
			return rst;
		else
			return 0;
		
	}
	
	public static void main(String[] args) {
		Roman2Int test = new Roman2Int();
		String input = "MMMMM";
		int output = test.romToInt(input);
		System.out.println("" + output);
	}

}
