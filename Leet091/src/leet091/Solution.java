package leet091;

public class Solution {

	public int numDecodings(String s) {
		int len = s.length();
		if (len <= 0 || s.charAt(0) == '0')
			return 0;
		int[] dp = new int[2];
		dp[0] = 1; dp[1] = 1;
		for (int i = 2; i <= len; i ++) {
			int n = s.charAt(i - 1) == '0' ? 0 : dp[(i - 1) % 2];
			int num = (int) (s.charAt(i - 2) - '0') * 10 + (int) (s.charAt(i - 1) - '0');
			if (num <= 26 && num > 0 && num != (int) (s.charAt(i - 1) - '0'))
				n += dp[(i - 2) % 2];
			dp[i % 2] = n;
		}
		return dp[len % 2];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "10120";
		System.out.println(new Solution().numDecodings(s));
	}

}
