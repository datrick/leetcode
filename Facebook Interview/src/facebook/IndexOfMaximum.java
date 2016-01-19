package facebook;

import java.util.Random;

public class IndexOfMaximum {
	
	public int indexOfMax(int[] nums) {
		if (nums == null || nums.length <= 0)
			return -1;
		Random randomNumber = new Random();
		int max = 0, n = 1;
		for (int i = 1; i < nums.length; i ++) {
			if (nums[i] > nums[max]) {
				max = i;
				n = 1;
			}
			if (nums[i] == nums[max]) {
				n += 1;
				int j = randomNumber.nextInt(n) + 1;
				if (j == n) {
					max = i;
				}
			}
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 3, 2, 4, 12, 9, 7, 12, 8, 3, 1, 12};
		IndexOfMaximum obj = new IndexOfMaximum();
		for (int i = 0; i < 9; i ++)
			System.out.println(obj.indexOfMax(nums));
	}

}
