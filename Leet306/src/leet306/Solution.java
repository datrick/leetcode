package leet306;

public class Solution {

	private String add2String(String s1, String s2) {
		char[] a = s1.toCharArray(), b = s2.toCharArray();
		StringBuilder sb = new StringBuilder();
		int i = a.length - 1, j = b.length - 1;
		int c = 0;
		while (i >= 0 && j >= 0) {
			int res = a[i --] + b[j --] + c - 2 * '0';
//			System.out.printf("%c + %c is %d%n", a[i + 1], b [j + 1], res);
			sb.insert(0, res % 10);
			c = res / 10;
		}
		while (i >= 0) {
			int res = c + a[i --] - '0';
			sb.insert(0, res % 10);
			c = res / 10;
		}
		while (j >= 0) {
			int res = c + b[j --] - '0';
			sb.insert(0, res % 10);
			c = res / 10;
		}
		if (c > 0)
			sb.insert(0, c);
//		System.out.printf("%s + %s is %s", s1, s2, sb.toString());
		return sb.toString();
	}
	
	public boolean isAdditiveNumber(String num) {
		if (num == null || num.length() <= 0)
			return false;
		int half = num.length() / 2 + 2;
		for (int i = 1; i <= num.length() && i <= half; i ++) {
			if (num.charAt(0) == '0' && i > 1)
				break;
			for (int j = i + 1; j <= num.length() && j - i <= half; j ++) {
				if (num.charAt(i) == '0' && j > i + 1)
					break;
				String num1 = num.substring(0, i), num2 = num.substring(i, j);
				int k = j;
//				System.out.println(num1 + " " + num2);
				while (k < num.length()) {
					String sum = this.add2String(num1, num2);
//					System.out.format("sum of %s and %s is %s%n", num1, num2, sum);
					int len = sum.length();
					if (k + len > num.length())
						break;
					if (sum.compareTo(num.substring(k, k + len)) == 0) {
						if (k + len == num.length())
							return true;
						num1 = num2;
						num2 = sum;
						k += len;
					} else
						break;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num = "0199100199";
		System.out.println(new Solution().isAdditiveNumber(num));
	}

}
