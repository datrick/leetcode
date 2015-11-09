package leet038;

public class Solution {

	public String countAndSay(int n) {
		StringBuilder sb = new StringBuilder();
		if (n == 0)
			return sb.toString();
		sb.append(1);
		for (int i = 1; i < n; i ++){
			StringBuilder newSb = new StringBuilder();
			for (int j = 0; j < sb.length(); ){
				char c = sb.charAt(j);
				int sum = 0;
				for ( ; j < sb.length() && sb.charAt(j) == c; sum ++, j ++) ;
				newSb.append(Integer.toString(sum));
				newSb.append(c);
			}
			sb = newSb;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().countAndSay(8));
	}

}
