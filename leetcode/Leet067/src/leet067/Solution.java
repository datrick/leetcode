package leet067;

public class Solution {

	static private String extendToLen(String s, int len){
		StringBuilder sb = new StringBuilder(len);
		sb.append(s);
		while (sb.length() < len)
			sb.insert(0, '0');
		return sb.toString();
	}
	
	public String addBinary(String a, String b) {
		if (a.length() == 0)
			return b;
		if (b.length() == 0)
			return a;
		int len = Math.max(a.length(), b.length());
		a = extendToLen(a, len);
		b = extendToLen(b, len);
//		System.out.printf("a: %s, b: %s\n", a, b);
		StringBuilder sb = new StringBuilder(len + 1);
		int c = 0;
		for(int i = a.length() - 1; i >= 0; i --){
			sb.insert(0, Integer.toString(((int) a.charAt(i) & 1) ^ ((int) b.charAt(i) & 1) ^ c));
			c = ((int) a.charAt(i) & 1) & ((int) b.charAt(i) & 1) | (((int) a.charAt(i) & 1) ^ ((int) b.charAt(i) & 1)) & c;
//			System.out.printf("%d: %c, %c, %s\n", i, a.charAt(i), b.charAt(i), sb.toString());
		}
		if (c == 1)
			sb.insert(0, '1');
		return sb.toString();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution obj = new Solution();
		String a = "100", b = "1011";
		System.out.println(obj.addBinary(a, b));
	}

}
