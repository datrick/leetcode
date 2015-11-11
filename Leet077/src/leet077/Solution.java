package leet077;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		if(n * k == 0)
			return result;
		int i, j, start;
		result.add(new ArrayList<Integer>());
		for(i = 1; i <= k; i ++){
			List<List<Integer>> tempList = new ArrayList<>();
			for(j = 0; j < result.size(); j ++){
				if(result.get(j).isEmpty())
					start = 1;
				else
					start = result.get(j).get(result.get(j).size() - 1) + 1;
				for(; start <= n; start ++){
					List<Integer> comb = new ArrayList<Integer>(result.get(j));
					comb.add(start);
					tempList.add(comb);
				}
			}
			result = tempList;
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution obj = new Solution();
		List<List<Integer>> result = obj.combine(6, 3);
		System.out.println(result);
	}

}
