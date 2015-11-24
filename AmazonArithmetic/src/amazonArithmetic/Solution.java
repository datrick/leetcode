package amazonArithmetic;

public class Solution {
	
	public static int solution(int[] A) {
		if (A.length < 3)
			return 0;
		long sum = 0;
		int l = 2, d = A[1] - A[0];
		for (int i = 2; i < A.length; i ++) {
			int tmp = A[i] - A[i - 1];
			if (tmp == d) {
				if (++ l >= 3)
					sum += (l - 2);
			} else {
				l = 2;
				d = tmp;
			}
		}
		if (sum > 1000000000)
			return -1;
		return (int) sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { -1, 1, 3, 3, 3, 2, 1, 0 };
		System.out.println(Solution.solution(A));
	}

}
