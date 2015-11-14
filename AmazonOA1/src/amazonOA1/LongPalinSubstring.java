package amazonOA1;


public class LongPalinSubstring {

	public String longestPalindromeSubstring(String s) {
		if (s == null)
			return new String("");
		if (s.length() <= 1)
			return s;
		char[] aos = new char[s.length() * 2 + 1];
		aos[0] = ' ';
		for (int i = 0; i < s.length(); i ++) {
			aos[2 * i + 1] = s.charAt(i);
			aos[2 * i + 2] = ' ';
		}
		int[] dp = new int[aos.length];
		int ind_max = 0;
		for (int i = 1, c = 0; i < aos.length; i ++) {
			if (i > c + dp[c]) 
				dp[i] = 0;
			else
				dp[i] = Math.min(dp[c - (i - c)], dp[c] + c - i);
			if (i + dp[i] >= c + dp[c]) {
				c = i;
				int l = 0;
				for (l = dp[i] + 1; i - l >= 0 && i + l < aos.length && aos[i - l] == aos[i + l]; l ++)	;
				dp[i] = l - 1;
			}
			if (dp[ind_max] < dp[i])
				ind_max = i;
		}
//		System.out.println(Arrays.toString(dp));
		int start_max = (ind_max - dp[ind_max]) / 2;
//		System.out.format("%d, %d%n", start_max, start_max + dp[ind_max]);
		return s.substring(start_max, start_max + dp[ind_max]);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abb";
		System.out.println(new LongPalinSubstring().longestPalindromeSubstring(s));
	}

}
