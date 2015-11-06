package leet209;

public class Solution {

	public int minSubArrayLen(int s, int[] nums) {
		if (s <= 0 || nums.length <= 0)
			return 0;
		int startIndex = 0, sum = 0, min = 0, i, j, n = nums.length;
		for (i = 0; i < n; i ++){
			sum += nums[i];
			if (sum >= s) {
				for (j = startIndex; j < i && sum - nums[j] >= s; sum -= nums[j ++]);
				if (i - j + 1 < min || min == 0)
					min = i - j + 1;
				startIndex = j;
			}
		}
		System.out.println(sum);
		System.out.println(startIndex);
		return min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2, 3, 1, 2, 4, 3};
		int s = 7;
		System.out.println(new Solution().minSubArrayLen(s, nums));
	}

}
