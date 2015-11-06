package leet039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {

	public List<List<Integer>> combinationSum2(int[] num, int target) {
		List<List<Integer>> rslt = new ArrayList<>();
		Stack<Integer> st = new Stack<>();
		Arrays.sort(num);
		for (int last_pop = -1, i = 0, sum = 0; i < num.length || !st.isEmpty(); ){
			if (i >= num.length){
				last_pop = st.pop();
				sum -= num[last_pop];
				for (i = last_pop + 1; i < num.length && num[i] == num[last_pop]; i ++);
			}
			if (sum < target && i < num.length){
				st.push(i);
				sum += num[i ++];
			}
			if (sum == target){
				List<Integer> tmpList = new ArrayList<Integer>();
				for (int j : st)
					tmpList.add(num[j]);
				rslt.add(tmpList);
			}
			if (sum >= target){
				for (int k = 0; k < 2 && !st.isEmpty(); k ++){
					last_pop = st.pop();
					sum -= num[last_pop];
				}
				for (i = last_pop + 1; i < num.length && num[i] == num[last_pop]; i ++);
			}
		}
		return rslt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {5,4,5,1,5,3,1,4,5,5,4};
		System.out.println(new Solution().combinationSum2(num, 10));
	}

}
