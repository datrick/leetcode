package leet053;

public class Solution {

	private int maxSubArrayRec(int[] A, int start, int end){
		if (start == end)
			return A[start];
		int mid = (start + end) / 2;
		int max = Math.max(this.maxSubArrayRec(A, start, mid), this.maxSubArrayRec(A, mid + 1, end));
		int leftMax = A[mid], rightMax = A[mid + 1], sum = 0, i;
		for (i = mid, sum = 0; i >= start; i --){
			sum += A[i];
			if (sum > leftMax)
				leftMax = sum;
		}
		for (i = mid + 1, sum = 0; i <= end; i ++){
			sum += A[i];
			if (sum > rightMax)
				rightMax = sum;
		}
		if (max > leftMax + rightMax)
			return max;
		return leftMax + rightMax;
	}
	
	public int maxSubArray(int[] A) {
		if (A.length == 0)
			return 0;
		return this.maxSubArrayRec(A, 0, A.length - 1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {-2, 1, -3, 4, -1 ,2, 1, -5, 4};
		System.out.println(new Solution().maxSubArray(A));
	}

}
