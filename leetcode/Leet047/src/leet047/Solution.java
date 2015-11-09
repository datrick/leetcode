package leet047;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	private List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> rslt = new ArrayList<>();
		if (num.length == 0)
			return rslt;
		Arrays.sort(num);
		rslt.add(new ArrayList<Integer>());
		rslt.get(0).add(num[0]);
		for (int i = 1; i < num.length; i ++){
			List<List<Integer>> tmpList = new ArrayList<>();
			for (List<Integer> aList : rslt){
				int start = 0;
				if (num[i] == num[i - 1])
					start = aList.lastIndexOf(num[i]) + 1;
				for (int j = start; j <= aList.size(); j ++){
					List<Integer> aNewList = new ArrayList<>(aList);
					aNewList.add(j, num[i]);
					tmpList.add(aNewList);
				}
			}
			rslt = tmpList;
		}
		return rslt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1, 2, 1, 2};
		System.out.println(new Solution().permuteUnique(num));
	}

}
