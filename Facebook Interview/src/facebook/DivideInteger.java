package facebook;

public class DivideInteger {

	public int divide(int dividend, int divisor) {
		boolean negative = dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0;
		dividend = dividend > 0 ? -1 * dividend : dividend;
		divisor = divisor > 0 ? -1 * divisor : divisor;
		int res = 0, tmp = 1, pow = 1;
		if (divisor == -1) {
			res = -1 * dividend;
		} else {
			while (dividend <= divisor) {
//				System.out.println(dividend + ", " + (dividend >> 1) + ", "+ divisor);
				for (pow = divisor, tmp = 1; pow >= (dividend + 1 >> 1); pow <<= 1, tmp <<= 1);
//				System.out.println(pow);
				res += tmp;
				dividend -= pow;
			}
		}
		if (res < 0)
			return negative ? res : Integer.MAX_VALUE;
		return negative ? -1 * res : res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dividend = Integer.MAX_VALUE, divisor = 2;
		System.out.println(new DivideInteger().divide(dividend, divisor));
	}

}
