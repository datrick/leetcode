package leet214;

public class Solution {

	public String shortestPalindrome(String s) {

		int m = s.length(), n = 2 * m + 1, i, mirror, center, max = 1;
		if (m <= 1)
			return s;
		int[] dp = new int[n];
		char[] ori = s.toCharArray(), mod = new char[n];
		for (int k = 0, l = 0; k < ori.length; k ++) {
			mod[l ++] = ' ';
			mod[l ++] = ori[k];
		}
		mod[n - 1] = ' ';
		dp[1] = 1;
		for (i = 2, center = 1; i < n; i ++) {
			mirror = 2 * center - i;
			int right = center + dp[center];
			if (i < right && i + dp[mirror] < right) {
				dp[i] = dp[mirror];
			} else {
				int j = i < right ? right + 1 - i : 1;
				for ( ; i - j >= 0 && i + j < n && mod[i - j] == mod[i + j]; j ++) ;
				dp[i] = j - 1;
				if (i + dp[i] >= center + dp[center])
					center = i;
			}
			if (dp[i] == i && i > max)
				max = i;
		}

		for (int r : dp)
			System.out.format("%d ", r);
		System.out.println("");
		if (max == m)
			return s;
		StringBuilder sb = new StringBuilder();
		for (int p = m - 1; p >= max; p --)
			sb.append(ori[p]);
		sb.append(ori);
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ababbbabbaba";
		System.out.println(new Solution().shortestPalindrome(s));
	}

}
