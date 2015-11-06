package leet294;

public class Solution {

	private boolean doWin(char[] s) {		
		for (int i = 0; i < s.length - 1; i ++) {
			if (s[i] == '+' && s[i + 1] == '+') {
				s[i] = '-';
				s[i + 1] = '-';
				if (!doWin(s)){
					s[i] = '+';
					s[i + 1] = '+';
					return true;
				}
				s[i] = '+';
				s[i + 1] = '+';
			}
		}
		return false;
	}
	
	public boolean canWin(String s) {
		char[] as = s.toCharArray();
		for (char c : as)
			System.out.println(c);
		return doWin(as);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "++++";
		System.out.println(new Solution().canWin(s));
	}

}
