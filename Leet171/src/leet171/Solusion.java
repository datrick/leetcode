package leet171;

public class Solusion {
	
	public int titleToNumber(String s) {
		int i = 0, num = 0;
		for(i = 0; i < s.length(); i ++){
			num = ((int)s.charAt(i) - (int)'A' + 1) + num * 26;
		}
		return num;
	}
	
	public static void main(String... arg){
		Solusion obj = new Solusion();
		System.out.format("%d\n", obj.titleToNumber("AC"));
	}
}
