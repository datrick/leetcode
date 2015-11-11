package leet060;

import java.util.LinkedList;
import java.util.List;

public class SolutionII {

	public String getPermutation(int n, int k) {
		k -= 1;
		int[] pTable = new int[n + 1];
		pTable[0] = 1;
		for (int i = 1; i <= n; i ++)
			pTable[i] = i * pTable[i - 1];
		StringBuilder sb = new StringBuilder();
		List<Integer> numbers = new LinkedList<>();
		for (int i = 0; i < n; i ++)
			numbers.add(i + 1);
		for (int i = 0; i < n; i ++){
			int index = k / pTable[n - 1 - i];
			sb.append(numbers.remove(index));
			k = k % pTable[n - 1 - i];
		}
		return sb.toString();
	}
}
