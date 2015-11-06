package leet273;

public class Solution {

	public String numberToWords(int num) {
		String[] table0to20 = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
				"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
				"Nineteen", "Twenty"	};
		String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
		String[] units = {"", " Thousand", " Million", " Billion"};
		int i = 0, g = 1000, res = 0;
		if (num == 0)
			return table0to20[0];
		StringBuilder sb = new StringBuilder();
		while (num > 0) {
			res = num % g;
			num /= g;
			if (res != 0) {
				sb.insert(0, units[i]);
				int ten = res % 100;
				res /= 100;
				if (ten != 0) {
					if (ten <= 20)
						sb.insert(0,  table0to20[ten]);
					else {
						int one = ten % 10;
						if (one != 0)
							sb.insert(0, " " + table0to20[one]);
						sb.insert(0, tens[ten / 10]);
					}
					if (res > 0)
						sb.insert(0, " ");
				}
				if (res > 0)
					sb.insert(0, table0to20[res] + " Hundred");
				if (num > 0)
					sb.insert(0, " ");
			}
			i ++;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().numberToWords(0));
	}

}
