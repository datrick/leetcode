package leet005;

public class Solution {

	public String longestPalindrome(String s) {
		if (s.length() <= 1 || s == null)
			return s;
		StringBuilder sb = new StringBuilder();
		sb.append(" ");
		for (int i = 0; i < s.length(); i ++)
			sb.append(s.substring(i, i + 1) + " ");
		String t = sb.toString();
		int[] dp = new int[t.length()];
		int center = 0, right = 0, i = 0, j = 0;
		for (i = 1; i < t.length(); i ++){
			if (i < right && i + dp[2 * center - i] < right)
				dp[i] = dp[2 * center - i];
			else {
				for (j = right + 1; j < t.length() && 2 * i - j >= 0 && t.charAt(j) ==  t.charAt(2 * i - j); j ++) ;
				dp[i] = j - 1 - i;
				if (j - 1 > right){
					center = i;
					right = j - 1;
				}
			}
		}
		int max = 0, startIndex = 0;
		for (i = 0; i < dp.length; i ++){
			if (dp[i] > max){
				max = dp[i];
				startIndex = (i - max) / 2;
			}
		}
		return s.substring(startIndex, startIndex + max);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aabacacab";
		String t = new Solution().longestPalindrome(s);
		System.out.println(t);
	}

}
