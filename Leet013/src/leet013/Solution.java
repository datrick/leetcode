package leet013;

public class Solution {

	public int romanToInt(String s) {
		int res = 0;
		for (int i = 0; i < s.length(); i ++) {
			char c = s.charAt(i);
			if (c == 'M')
				res += 1000;
			else if (c == 'D')
				res += 500;
			else if (c == 'C'){
				if (i < s.length() - 1 && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')){
					res += s.charAt(i + 1) == 'D' ? 400 : 900;
					i += 1;
				} else {
					res += 100;
				}
			} else if (c == 'L')
				res += 50;
			else if (c == 'X'){
				if (i < s.length() - 1 && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')){
					res += s.charAt(i + 1) == 'L' ? 40 : 90;
					i += 1;
				} else {
					res += 10;
				}
			} else if (c == 'V')
				res += 5;
			else if (c == 'I'){
				if (i < s.length() - 1 && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')){
					res += s.charAt(i + 1) == 'V' ? 4 : 9;
					i += 1;
				} else {
					res += 1;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().romanToInt("X"));
	}

}
