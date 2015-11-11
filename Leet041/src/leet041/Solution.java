package leet041;

public class Solution {

	public int firstMissingPositive(int[] A) {
		int len = A.length;
		for (int i = 0; i < len; i ++){
			for (int j = i, val = A[j]; val > 0 && val <= len && j != val - 1;){
				int tmp = A[val - 1];
				A[val - 1] = val;
				j = val - 1;
				val = tmp;
			}
		}
		int i;
		for (i = 0; i < len; i ++)
			if (A[i] != i + 1)
				break;
		return i + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1, 2, 0};
		for (int i = 0; i < A.length; i ++)
			System.out.printf("%d ", A[i]);
		System.out.println("");
		System.out.println(new Solution().firstMissingPositive(A));
	}

}
