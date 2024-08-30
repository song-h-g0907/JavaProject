package m.api.ex2;

import java.util.StringTokenizer;

public class TokenController {

	public TokenController() {
		super();
	}
	public String afterToken(String str) {
		StringTokenizer stn = new StringTokenizer(str," ");
		String res="";
		while(stn.hasMoreElements()) {
			res+=stn.nextToken();
		}
		return res;
	}
	public String firstCap(String input) {
		String str = input.substring(0,1).toUpperCase()+input.substring(1,input.length());
		return str;
	}
	public int findChar(String input, char one) {
		int count = 0;
		char[] arr = input.toLowerCase().toCharArray();
		for(int i = 0 ; i < arr.length; i++) {
			if(arr[i]==one) {
				count++;
			}
		}
		return count;
	}
}
