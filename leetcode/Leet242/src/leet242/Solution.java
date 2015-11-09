package leet242;

public class Solution {

	public boolean isAnagram(String s, String t) {
		int[] counter = new int[26];
		for (char c: s.toCharArray())
			counter[(int) (c - 'a')] ++;
		for (char c: t.toCharArray())
			counter[(int) (c - 'a')] --;
		for (int i: counter)
			if (i != 0)
				return false;
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
