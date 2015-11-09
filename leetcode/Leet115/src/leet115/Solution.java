package leet115;

public class Solution {

	private int numRecur(String S, String T, int start, int end, int m){
		if(m >= T.length())
			return 1;
		int sum = 0;
		for(int i = start; i <= end; i ++)
			if(S.charAt(i) == T.charAt(m))
				sum += numRecur(S, T, i + 1, end, m + 1);
		return sum;
	}

	private int numDP(String S, String T){
		int[][] OPT = new int[S.length()][T.length()];
		if(S.charAt(0) == T.charAt(0))
			OPT[0][0] = 1;
		char c = T.charAt(0);
		for(int i = 1; i < S.length(); i ++)
			if(S.charAt(i) == c)
				OPT[i][0] = OPT[i - 1][0] + 1;
			else
				OPT[i][0] = OPT[i - 1][0];
		for(int i = 1; i < S.length(); i ++)
			for(int j = 1; j < T.length(); j ++){
				if(S.charAt(i) == T.charAt(j))
					OPT[i][j] = OPT[i - 1][j - 1] + OPT[i - 1][j];
				else
					OPT[i][j] = OPT[i - 1][j];
			}
		return OPT[S.length() - 1][T.length() - 1];
	}
	public int numDistinct(String S, String T) {
		int start = S.indexOf(T.charAt(0)), end = S.lastIndexOf(T.charAt(T.length() - 1));
		//		System.out.printf("start: %d, end: %d\n", start, end);
		if(start < 0 || end < 0 || end - start + 1 < T.length())
			return 0;
//		return numRecur(S, T, start, end, 0);
		return numDP(S, T);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc";
		String T = "bcddceeeebecbc";
		Solution obj = new Solution();
		System.out.println(obj.numDistinct(S, T));
	}

}
