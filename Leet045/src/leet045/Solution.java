package leet045;


public class Solution {

	public int jump(int[] A) {
		int steps = 0, curStart = 0, curMax = 0, nextMax = 0;
		while (steps < A.length && curMax < A.length - 1){
			for (int i = curStart; i < A.length && i <= curMax; i ++)
				nextMax = i + A[i] > nextMax ? i + A[i] : nextMax;
			steps += 1;
			curStart = curMax + 1;
			curMax = nextMax;
		}
		return steps;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {0};
		System.out.println(new Solution().jump(A));
	}

}
