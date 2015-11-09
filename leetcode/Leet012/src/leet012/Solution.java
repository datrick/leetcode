package leet012;

public class Solution {

	public String intToRoman(int num) {
		String[][] table = { {"I", "V"}, {"X", "L"}, {"C", "D"}, {"M"} };
		int i = 0;
		StringBuilder res = new StringBuilder();
		while (num > 0) {
			int digit = num % 10;
			num /= 10;
			StringBuilder sb = new StringBuilder();
			while (digit > 0) {
				if (digit == 9){
					sb.append(table[i][0] + table[i + 1][0]);
					digit -= 9;
				} else if (digit >= 5) {
					sb.append(table[i][1]);
					digit -= 5;
				} else if (digit == 4) {
					sb.append(table[i][0] + table[i][1]);
					digit -= 4;
				} else {
					sb.append(table[i][0]);
					digit -= 1;
				}
			}
			i ++;
			res.insert(0, sb);
		}
		return res.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().intToRoman(3999));
	}

}
