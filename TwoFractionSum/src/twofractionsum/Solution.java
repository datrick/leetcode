package twofractionsum;

import java.math.BigInteger;

public class Solution {

	public String addTwoFraction(String exp) {
		//possible manipulations, like delete white space
		//validate the expression
		int num1 = Integer.valueOf(exp.substring(0, exp.indexOf('/')));
		int den1 = Integer.valueOf(exp.substring(exp.indexOf('/') + 1, exp.indexOf('+')));
		int num2 = Integer.valueOf(exp.substring(exp.indexOf('+') + 1, exp.indexOf('/', exp.indexOf('+'))));
		int den2 = Integer.valueOf(exp.substring(exp.indexOf('/', exp.indexOf('+')) + 1));
//		System.out.format("%d/%d + %d/%d%n", num1, den1, num2, den2);
		int gcd_d = BigInteger.valueOf(den1).gcd(BigInteger.valueOf(den2)).intValue();
		int den_com = den1 * den2 / gcd_d;
		int num_com = num1 * (den_com /den1) + num2 * (den_com / den2);
//		System.out.format("%d/%d%n", num1, num2);
		gcd_d = BigInteger.valueOf(num_com).gcd(BigInteger.valueOf(den_com)).intValue();
		num_com /= gcd_d;
		den_com /= gcd_d;
		StringBuilder sb = new StringBuilder();
		sb.append(num_com);
		sb.append('/');
		sb.append(den_com);
		return sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String exp = "1/6+2/6";
		System.out.println(new Solution().addTwoFraction(exp));
	}

}
