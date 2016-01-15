package leet125;

public class Solution {

	private boolean isAlphaNumeric(char c) {
		return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9';
	}
	public boolean isPalindrome(String s) {
		if (s == null)
			return false;
		if (s.length() <= 1)
			return true;
		int i = 0, j = s.length() - 1;
		while (i <= j) {
			for (char c = s.charAt(i); i < j && !isAlphaNumeric(c); c = s.charAt(++ i));
			for (char c = s.charAt(j); i < j && !isAlphaNumeric(c); c = s.charAt(-- j));
			if (i >= j)
				return true;
			if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
				return false;
			i ++;
			j --;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "race a car";
		System.out.println(new Solution().isPalindrome(s));
	}

}
