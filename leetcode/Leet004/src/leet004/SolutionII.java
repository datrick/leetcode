package leet004;

public class SolutionII extends Solution {

	private int kthValue(int[] A, int startA, int endA, int[] B, int startB, int endB, int k) {
		int lenA = endA - startA + 1, lenB = endB - startB + 1;
		if (lenB > lenA)
			return this.kthValue(B, startB, endB, A, startA, endA, k);
		if (lenB <= 0)
			return A[startA + k - 1];
		if (k == 1)
			return Math.min(A[startA], B[startB]);
		int j = Math.min(lenB, k / 2), i = k - j;
		if (A[startA + i - 1] > B[startB + j - 1])
			return this.kthValue(A, startA, startA + i - 1, B, startB + j, endB, k - j);
		else
			return this.kthValue(A, startA + i, endA, B, startB, startB + j - 1, k - i);
			
	}
	public double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length, n = B.length;
		int k = (m + n + 1) / 2;
		int midValue = this.kthValue(A, 0, m - 1, B, 0, n - 1, k);
		if ((m + n) % 2 == 1)
			return (double) midValue;
		else 
			return ((double) midValue + (double) this.kthValue(A, 0, m - 1, B, 0, n - 1, k + 1)) / 2;
	}
}
