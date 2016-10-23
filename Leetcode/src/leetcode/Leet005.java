package leetcode;

public class Leet005 {

	public String longestPalindrome(String s) {
		if (s == null || s.length() <= 1)
			return s;
		char[] a = new char[s.length() * 2 + 1];
		for (int i = 0; i < a.length; i ++)
			a[i] = (i % 2 == 0) ? ' ' : s.charAt(i / 2);
		int[] dp = new int[a.length];
		int c = 0, idx = -1, max = Integer.MIN_VALUE;
		for (int i = 1; i < dp.length; i ++) {
			if ((i < c  + dp[c]) && (i + dp[2 * c - i] < c + dp[c])) {
				dp[i] = dp[2 * c - i];
			} else {
				dp[i] = (i >= c + dp[c]) ? 0 : c + dp[c] - i;
				for (int j = Math.max(i + 1, dp[c] + c + 1); j < a.length && 2 * i - j >= 0; j ++) {
					if (a[j] == a[2 * i - j])
						dp[i] ++;
					else
						break;
				}
				c = i;
			}
			if (dp[i] > max) {
				max = dp[i];
				idx = i;
			}
		}
		int start = (idx - max) / 2;
		//System.out.println(start + ":" + max + "len: " + s.length());
		return s.substring(start, start + max);
	}
	public static void main(String[] args) {
		String s = "abcbad";
		System.out.println(new Leet005().longestPalindrome(s));
	}

}
