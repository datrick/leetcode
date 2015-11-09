package leet167;

import java.util.Arrays;

public class Solution {
	
	public int[] twoSum(int[] numbers, int target) {
		int[] res = new int[2];
		for (int i = 0, j = numbers.length-1; i < numbers.length && i < j; ) {
			if (numbers[i] + numbers[j] == target) {
				res[0] = i + 1;
				res[1] = j + 1;
				return res;
			}
			if (numbers[i] + numbers[j] < target)
				i ++;
			else 
				j --;
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println(Arrays.toString(new Solution().twoSum(numbers, 7)));
	}

}
