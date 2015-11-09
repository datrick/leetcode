package leet001;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

	public int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> numMap = new HashMap<>();
		int[] res = new int[2];
		for (int i = 0; i < numbers.length; i ++) {
			if (numMap.containsKey(target - numbers[i])){
				res[1] = i + 1;
				res[0] = numMap.get(target - numbers[i]) + 1;
				break;
			}
			numMap.put(numbers[i], i);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {2, 7, 11, 15};
		System.out.println(Arrays.toString(new Solution().twoSum(numbers, 9)));
	}

}
