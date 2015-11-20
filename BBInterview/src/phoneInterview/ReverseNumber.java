package phoneInterview;

public class ReverseNumber {

	private double reverseLong(long num) {
		long res = 0;
		while (num > 0) {
			res = res * 10 + num % 10;
			num /= 10;
		}
		return (double) res;
	}
	
	public double reverseNumber(double num) {
		boolean negative = false;
		if (num < 0) {
			negative = true;
			num *= -1;
		}
		System.out.println(num);
		String s = Double.toString(num);
		System.out.println(s);
		double whole = Double.valueOf(s.split("\\.")[0]);
		double frac = Double.valueOf(s.split("\\.")[1]);
//		System.out.println(whole);
//		System.out.println(frac);
		while (frac != Math.floor(frac))
			frac *= 10;
		double whole_r = reverseLong((long) whole), frac_r = reverseLong((long) frac);
		while (whole_r > 1)
			whole_r /= 10;
		double res = whole_r + frac_r;
		if(Double.isInfinite(res) || Double.isNaN(res) || Double.toString(res).contains("E"))
			throw new ArithmeticException("illegle double" + res);
		else
			return negative ? -1 * res : res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double num = 99999999992352.7678644444445;
		ReverseNumber obj = new ReverseNumber();
		System.out.println(obj.reverseNumber(num));
	}

}
