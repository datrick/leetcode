package leet132;

public class Solution {

	public int minCut(String s) {
		if(s.length() < 2)
			return 0;
		int[][] isPal = new int[s.length()][s.length()];
		int i, j;
		for(i = 0; i < isPal.length; i ++){
			isPal[i][i] = 1;
			if(i + 1 < isPal.length && s.charAt(i) == s.charAt(i + 1))
				isPal[i][i+1] = 1;
		}
		
		for(i = isPal.length; i >= 0; i --)
			for(j = i + 2; j < isPal.length; j ++)
				if(isPal[i+1][j-1] == 1 && s.charAt(i) == s.charAt(j))
					isPal[i][j] = 1;
		
		int[] minCutSeries = new int[s.length()];
		for(i = 0; i < s.length(); i ++){
			if(isPal[0][i] == 1)
				minCutSeries[i] = 0;
			else{
				int curMin = Integer.MAX_VALUE;
				for(j = 1; j <= i; j ++){
					if(isPal[j][i] == 1 && minCutSeries[j - 1] + 1 < curMin)
						curMin = minCutSeries[j - 1] + 1;
				}
				minCutSeries[i] = curMin;
			}
		}
		return minCutSeries[s.length() - 1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aabbaaa";
		Solution obj = new Solution();
		System.out.println(obj.minCut(s));
	}

}
