package leet050;

public class Solution {

	public double pow(double x, int n) {
		int m = n;
		if (n < 0)
			m = -1 * n;
		double power = 1.0, temp = x;
		while (m > 0){
			int t = 1;
			temp = x;
			while ((m - t) >= t){
				temp *= temp;
				t *= 2;
			}
			m -= t;
			power *= temp;
		}
		if (n >= 0)
			return power;
		else
			return 1 / power;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		for (int i = 0; i < 10; i ++)
			System.out.println(new Solution().pow(34.00515, -3));
	}

}
