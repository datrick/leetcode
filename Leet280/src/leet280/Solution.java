package leet280;


public class Solution {

	private void swapPre(int[] nums, int i) {
		if (i <= 0)
			return;
		int tmp = nums[i - 1];
		nums[i - 1] = nums[i];
		nums[i] = tmp;
		return;
	}
	public void wiggleSort(int[] nums) {
		if (nums == null || nums.length <= 0)
			return;
		for (int i = 1; i < nums.length; i ++) {
			if (i % 2 == 0) {
				if (nums[i] > nums[i - 1])
					swapPre(nums, i);
			} else {
				if (nums[i] < nums[i - 1])
					swapPre(nums, i);
			}
		}
		return;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{3, 5, 2, 1, 6, 4};
		new Solution().wiggleSort(nums);
//		System.out.println(Arrays.asList(nums).toString());
		for (int v: nums)
			System.out.printf("%d ", v);
	}

}
