package amazonOA1;

import java.util.ArrayList;
import java.util.List;

public class AddSumK {
	//first calculate the sum of first k numbers as the first sum
	//in each step, move the window to right by 1
	//subtract the left-most number in the previous window and add up the new number
	//when the program completes, we go through the array A once, the total time complexity is O(n)
	//space complexity is O(1), ignoring the return list space
	public static List<Integer> getSum(int[] A, int k){
		if (A == null || A.length < k || k <= 0)
			return new ArrayList<>();	//illegal input, return a empty list
		List<Integer> rslt = new ArrayList<>();
		int tmp = 0;
		for (int i = 0; i < k; i ++)	//calculate the first window sum
			tmp += A[i];
		rslt.add(tmp);
		for (int i = k; i < A.length; i ++) 	//subtract the last one and add the new one
			rslt.add(rslt.get(i - k) - A[i - k] + A[i]);
		return rslt;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {4, 2, 73, 11, -5};
		System.out.println(AddSumK.getSum(A, 2).toString());
	}

}
