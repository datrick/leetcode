package leet055;

public class Solution {

	public boolean canJump(int[] A) {
		int curMax = 0, i;
		for (i = 0; i <= curMax && i < A.length; i ++)
			curMax = Math.max(curMax, (A[i] + i));
		if (i >= A.length)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {3, 2, 1, 0, 4};
		Solution obj = new Solution();
		System.out.println(obj.canJump(A));
	}

}
