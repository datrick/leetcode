package facebook;

public class IndexOfPeekOrValey {
	public int findIndex(int[] nums) {
		if (nums == null || nums.length <= 2)
			return -1;
		int len = nums.length, x = 0, y = 0;
		if (nums[len - 1] - nums[0] == len - 1 || nums[len - 1] - nums[0] == 1 - len)
			return -1;
		x = (nums[len - 1] - nums[0] + len - 1) / 2;
		y = len - 1 - x;
		if (nums[1] > nums[0])
			return x;
		else
			return y;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4, 5, 4};
		System.out.println(new IndexOfPeekOrValey().findIndex(nums));
	}

}
