package frogjumping;

public class Solution {
	
	public int solution( int[] A, int X, int D) {
		if (D >= X)
			return 0;
		if (A.length <= 0)
			return -1;
//		if (A[0] <= D && A[0] + D >= X)
//			return 0;
		int size = X / D + 1;
		int[] minBucket = new int[size], maxBucket = new int[size];
		for (int i = 0; i < size; i ++) {
			minBucket[i] = Integer.MAX_VALUE;
			maxBucket[i] = Integer.MIN_VALUE;
		}
		int t = 0;
		for (t = 0; t < A.length; t ++) {
			int n = A[t] / D;
			if (A[t] < minBucket[n]) {
				minBucket[n] = A[t];
				if (n > 0 && A[t] - D <= maxBucket[n - 1])
					minBucket[n] = minBucket[n - 1];
			}
			if (A[t] > maxBucket[n]) {
				maxBucket[n] = A[t];
				if (n < size - 1 && A[t] + D >= minBucket[n + 1])
					maxBucket[n] = maxBucket[n + 1];
			}
			maxBucket[minBucket[n] / D] = maxBucket[n];
			minBucket[maxBucket[n] / D] = minBucket[n];
			if (minBucket[n] - D <= 0 && maxBucket[n] + D >= X)
				return t;
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2, 9, 3, 8, 6, 5, 4};
		int X = 10, D = 3;
		System.out.println(new Solution().solution(A, X, D));
	}

}
