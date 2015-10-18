package leet042;

import java.util.Stack;

public class Solution {

	public int trap(int[] A) {
		if (A.length <= 2)
			return 0;
		Stack<Integer> st = new Stack<>();
		st.push(0);
		int sum = 0;
		for (int i = 1; i < A.length; i ++){
			while (st.size() > 1 && A[st.peek()] < A[i]){
				int k = st.pop();
				int amount = (Math.min(A[st.peek()], A[i]) - A[k]) * (i - st.peek() - 1);
				if (amount > 0)
					sum += amount;
			}
			st.push(i);
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {0,1,2,0,3,4,5,6,7,6,2,1};
		System.out.println(new Solution().trap(A));
	}

}
