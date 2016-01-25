package facebook;

public class MinSubArray {

	int minSubArrayLen(int[] nums, int s) {
		if (nums == null || nums.length <= 0)
			return 0;
		int i = 0, j = 0, min = Integer.MAX_VALUE, sum = 0;
		while (j < nums.length) {
			sum += nums[j ++];
			if (sum >= s) {
				while (sum >= s && i < j)
					sum -= nums[i ++];
				min = Math.min(min, j - i + 1);
			}
		}
		if (min == Integer.MAX_VALUE)
			return 0;
		return min;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,3,1,2,4,3};
		int s = 0;
		System.out.println(new MinSubArray().minSubArrayLen(nums, s));
	}

}
