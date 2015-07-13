package string2integer;

public class Atoi {
    public int myAtoi(String str) {
        if(str == null) return 0;
        int  index = 0;
        int  num = 0;
        int sign = 1;
        //discards all the front whitespace
        while(index < str.length()) {
            if (str.charAt(index) == ' ') {
                index ++;
                continue;
            }
            
            if (str.charAt(index) == '+' || str.charAt(index) == '-') {
                sign = str.charAt(index) == '-' ? -1 : 1 ;
                char nxt = str.charAt(++index);
                if (nxt >= '0' && nxt <= '9') {
                    continue; 
                } else {
                    return 0;
                }
            } else if(str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            	System.out.println("debug point 1");
                break;
            } else {
                return 0;
            }
        }
        // 
        if (index < str.length()) {
            int max = Integer.MAX_VALUE;
            int min = Integer.MIN_VALUE;

            if(str.charAt(index) >= '0' && str.charAt(index) <= '9') {
                while(index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
                    int dif = (int)(str.charAt(index) - '0');
                    if(sign == 1) {
                    	// if the number is positive, num * 10 + dif <= max.
                        if(num <= (max - dif)/10){
                            num = num * 10 + dif;
                            index ++;
                        } else {
                            return max;
                        }
                    } else {
                    	//if the number is negative, the judging criteria will change.
                    	//-num * 10 - dif >= min
                        if(num <= (min + dif)/-10){
                            num = num * 10 + dif;
                            index ++;
                        } else {
                            return min;
                        }
                    }
                }
                return num *= sign;
            } else {
                return 0;
            }
        }
        else {
            return 0;
        }
    }
   
   public static void main(String[] args) {
	   String input = "  -00134";
	   int output = 0;
	   Atoi test = new Atoi();
	   output = test.myAtoi(input);
	   System.out.println("" + output);
   }
}
