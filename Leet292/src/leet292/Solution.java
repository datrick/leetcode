package leet292;

public class Solution {

	public boolean canWinNim(int n) {
		if (n % 4 == 0)
			return false;
		return true;
/*		boolean[] dp = new boolean[4];
		for (int i = 1; i <= 3; i ++)
			dp[i] = true;
		for (int i = 4; i <= n; i ++) {
			if (dp[(i - 1) % 4] && dp[(i - 2) % 4] && dp[(i - 3) % 4])
				dp[i % 4] = false;
			else
				dp[i % 4] = true;
		}
		return dp[n % 4];*/
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().canWinNim(5));
	}

}
