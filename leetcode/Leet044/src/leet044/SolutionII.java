package leet044;


public class SolutionII extends Solution {

	private boolean isSame(char c1, char c2){
		if (c1 == c2 || c1 == '?' || c2 == '?' || c1 == '*' || c2 == '*')
			return true;
		return false;
	}
	
	private char[] transToArray(String s){
		char[] rsay = new char[s.length() + 1];
		for (int i = 1; i < s.length() + 1; i ++)
			rsay[i] = s.charAt(i - 1);
		return rsay;
	}
	
	public boolean isMatch(String s, String p){
		char[] sArray = this.transToArray(s), pArray = this.transToArray(p);
		boolean[][] dp = new boolean[2][pArray.length];
		boolean[] collum = new boolean[pArray.length];
		dp[0][0] = true;
		collum[0] = true;
		for (int i = 1; i < dp[0].length; i ++)
			if (pArray[i] == '*' && dp[0][i - 1]){
				dp[0][i] = true;
				collum[i] = true;
			}
			else
				dp[0][i] = false;
//		for (int i = 0; i < dp[0].length; i ++)
//			System.out.printf("%5s ", Boolean.toString(dp[0][i]));
		for (int i = 1; i < sArray.length; i ++){
			boolean existed = false;
			dp[i % 2][0] = (sArray[i] == '*' && dp[(i - 1) % 2][0]) ? true : false;
			for (int j = 1; j < pArray.length; j ++){
				if (pArray[j] == '*'){
					if (collum[j - 1]){
						dp[i % 2][j] = true;
						collum[j] = true;
						existed = true;
					}
					continue;
				}
				if (isSame(sArray[i], pArray[j]) && dp[(i - 1) % 2][j - 1]){
					existed = true;
					dp[i % 2][j] = true;
					collum[j] = true;
					continue;
				}
				dp[i % 2][j] = false;
			}
//			if (!existed)
//				return false;
		}
//		for (int i = 0; i < dp.length; i ++){
//			for (int j = 0; j < dp[0].length; j ++)
//				System.out.printf("%5s ", Boolean.toString(dp[i][j]));
//			System.out.println("");
//		}
//		System.out.println("");
		return dp[(sArray.length - 1) % 2][pArray.length - 1];
	}

}
