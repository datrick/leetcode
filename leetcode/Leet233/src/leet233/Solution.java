package leet233;

public class Solution {

	public int countDigitOne(int n) {
		int base = 0, power = 1, sum = 0, res = 0, m = n;
		while (m > 0) {
			int k = m % 10;
			res = base * k;
			if (k > 1)
				res += power;
			if (k == 1)
				res += (n % power + 1);
			sum += res;
			base = 10 * base + power;
			power *= 10;
			m /= 10;
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().countDigitOne(13));
	}

}
