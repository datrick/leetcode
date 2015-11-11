package leet267;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	private List<String> doGenPal(int[] dict, StringBuilder sb, int flag) {
		List<String> rslt = new ArrayList<>();
		int ind = sb.length() / 2;
		for (int i = 0; i < dict.length; i ++) {
			if (dict[i] != 0) {
				char c = (char) i;
				sb.insert(ind + flag, c);
				sb.insert(ind, c);
				dict[i] -= 2;
				rslt.addAll(doGenPal(dict, sb, flag));
				dict[i] += 2;
				sb.deleteCharAt(ind);
				sb.deleteCharAt(ind + flag);
			}
		}
		if (rslt.isEmpty())
			rslt.add(sb.toString());
		return rslt;
	}
	
	public List<String> generatePalindromes(String s) {
		int[] dict = new int[256];
		for (char c: s.toCharArray())
			dict[(int) c] ++;
		int indOdd = -1;
		for (int i = 0; i < dict.length; i ++)
			if (dict[i] % 2 != 0) {
				if (indOdd != -1)
					return new ArrayList<String>();
				else
					indOdd = i;
			}
		StringBuilder sb = new StringBuilder();
		int flag = 0;
		if (indOdd != -1) {
			dict[indOdd] --;
			sb.append((char) (indOdd));
			flag = 1;
		}
		return doGenPal(dict, sb, flag);	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "acacb";
		System.out.println(new Solution().generatePalindromes(s));
	}

}
