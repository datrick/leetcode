package leet216;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> rslt = new ArrayList<>();
		if (k <= 0 || n <= 0 || k > 9)
			return rslt;
		List<Integer> list = new ArrayList<>();
		this.findCom(list, 1, 0, k, n, rslt);
		return rslt;
	}

	private void findCom(List<Integer> list, int start, int sum, int k, int n, List<List<Integer>> rslt) {

		int size = list.size();
		if (size == k - 1) {
			int last = n - sum;
			if (last >= start && last <= 9) {
				list.add(last);
				rslt.add(new ArrayList<>(list));
				list.remove(size);
			}
			return;
		}

		for (int i = start; i < 10; i ++) {
			if (sum + i * (k - size) >= n || sum + 9 * (k - size) <= n)
				return;
			list.add(i);
			findCom(list, i + 1, sum + i, k, n, rslt);
			list.remove(size);
		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().combinationSum3(3, 20));
	}

}
