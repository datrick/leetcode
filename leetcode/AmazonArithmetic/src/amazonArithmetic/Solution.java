package amazonArithmetic;

public class Solution {
	
	public int solution(int[] A) {
		if (A.length < 3)
			return 0;
		int sum = 0;
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
		return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
