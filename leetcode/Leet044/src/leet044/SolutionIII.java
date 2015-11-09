package leet044;

public class SolutionIII extends Solution {

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
	
	public boolean isMatchdp(String s, String p){
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
					continue;
				}
				dp[i % 2][j] = false;
			}
			if (!existed)
				return false;
		}
		return dp[(sArray.length - 1) % 2][pArray.length - 1];
	}
	
	private boolean checkMatch(String s, int ss, int es, String p, int sp, int ep){
		if (es -ss <= 1024 && ep - sp <= 1024)
			return isMatchdp(s.substring(ss, es), p.substring(sp, ep));
		if (ss >= es && sp >= ep)
			return true;
		if (sp >= ep)
			return false;
		if (es > s.length() || ep > p.length() || ss < 0 || sp < 0)
			return false;
//		System.out.format("ss: %d, es: %d\n", ss, es);
//		System.out.format("s: %s\n", s.substring(ss, es)/*, p.substring(sp, ep)*/);
		int maxs = -1, maxl = 0;
		for (int start = -1, i = sp; i <= ep; i ++){
			if (i < ep && p.charAt(i) != '?' && p.charAt(i) != '*'){
//				System.out.println(p.charAt(i));
				if (start == -1){
					start = i;
				}
			} else {
				if (start != -1){
					if (i - start > maxl){
					maxs = start;
					maxl = i - start;
//					System.out.format("maxs: %s\n", p.substring(maxs, maxs + maxl));
					}
					start = -1;
				}
			}
		}
		if (maxl > 0){
//			System.out.format("maxs: %d, maxl: %d\n", maxs, maxl);
//			System.out.format("max substring: %s\n\n", p.substring(maxs, maxs + maxl));
			for (int i = ss; i < es;){
				int newss = s.indexOf(p.substring(maxs, maxs + maxl), i);
				if (newss == -1 || newss + maxl>= es)
					return false;
				if (this.checkMatch(s, ss, newss, p, sp, maxs) && this.checkMatch(s, newss + maxl, es, p, maxs + maxl, ep))
						return true;
				else
					i += 1;
			}
			return false;
		} else {
			int ls = es - ss, lp = ep - sp;
			for (int i = sp; i < ep; i ++){
				if (p.charAt(i) == '?'){
					ls --;
					lp --;
				}
			}
			if (ls == 0 || (ls > 0 && lp > 0))
				return true;
			else
				return false;
		}
	}
	
	public boolean isMatch(String s, String p) {
		return this.checkMatch(s, 0, s.length(), p, 0, p.length());
	}
	
}
