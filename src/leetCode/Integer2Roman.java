package leetCode;
import java.lang.StringBuffer;
public class Integer2Roman {
	private String symbol[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
	private int num[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
	
	public String IntToRoman(int n){
		StringBuffer roman = new StringBuffer();
		if(n<1 || n>3999) {
			System.out.println("Invalid input!");
			return null;
		}
		for(int i = 0; i < num.length; i++) {
			if(n>=1 && n<=3999) {
				int count = n / num[i];
//				System.out.println(""+ count);
				if(count != 0) {
					for(int j = 0; j < count; j++) {
						roman.append(symbol[i]);
					}
				}
				n = n % num[i];
			}

		}
		return roman.toString();
	}
	
	public static void main(String[] args) {
		Integer2Roman test = new Integer2Roman();
		int input = 299;
		String output = test.IntToRoman(input);
		System.out.println(output);
	}
}
