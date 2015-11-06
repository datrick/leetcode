package leet040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	private void combinationSumRec(int[] num, int i, int target, List<Integer> tplt, List<List<Integer>> rslt){
		if (i >= num.length)
			return;
		if (target <= 0)
			return;
		int j = 0, k = 0;
		for (j = 0; j * num[i] < target; j ++){
			this.combinationSumRec(num, i + 1, target - j * num[i], tplt, rslt);
			tplt.add(num[i]);
		}
		if (j * num[i] == target)
			rslt.add(new ArrayList<>(tplt));
		for (k = 0; k < j; k ++)
			tplt.remove(tplt.size() - 1);
		return;		
	}
	
	public List<List<Integer>> combinationSum(int[] num, int target) {
//		Map<Integer, List<List<Integer>>> map = new HashMap<>();
//		map.put(target, new ArrayList<List<Integer>>());
		Arrays.sort(num);
		List<List<Integer>> rslt = new ArrayList<>();
		List<Integer> tplt = new ArrayList<>();
		this.combinationSumRec(num, 0, target, tplt, rslt);
		return rslt;
//		for (int i = 0; i < num.length; i ++){
//			int sum = num[i];
//			List<Integer> listOfNumi = new ArrayList<>();
//			listOfNumi.add(num[i]);
//			while (sum <= target){
//				if (map.containsKey(target - sum)){
//					for (List<Integer> tmp : map.get(target - sum)){
//						List<Integer> targetList = new ArrayList<>(tmp);
//						targetList.addAll(listOfNumi);
//						if (!map.get(target).contains(targetList))
//							map.get(target).add(targetList);
//					}
//				}
//				if (! map.containsKey(sum))
//					map.put(sum, new ArrayList<List<Integer>>());
//				if (!map.get(sum).contains(listOfNumi))
//					map.get(sum).add(new ArrayList<Integer>(listOfNumi));
//				sum += num[i];
//				listOfNumi.add(num[i]);
//			}
//		}
//		return map.get(target);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {2, 2, 2, 3, 4};
		System.out.println(new Solution().combinationSum(num, 5));
	}

}
