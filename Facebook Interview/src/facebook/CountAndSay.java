package facebook;

public class CountAndSay {
	String countAndSay(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length();) {
			char c = s.charAt(i);
			int j = i + 1;
			while (j < s.length() && s.charAt(j) == c)
				j ++;
			sb.append(j - i);
			sb.append(c);
			i = j;
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "311233";
		System.out.println(new CountAndSay().countAndSay(s));
	}

}
