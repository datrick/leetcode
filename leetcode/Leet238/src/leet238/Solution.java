package leet238;

import java.util.Arrays;

public class Solution {

	public int[] productExceptSelf(int[] nums) {
		if (nums == null)
			return null;
		int len = nums.length;
		int[] rsay = new int[len];
		if (len <= 0)
			return rsay;
		rsay[len - 1] = 1;
		for (int i = len - 2; i >= 0; i --) {
			rsay[i] = rsay[i + 1] * nums[i + 1];
		}
		for (int p = 1, i = 0; i < len; i ++) {
			rsay[i] *= p;
			p *= nums[i];
		}
		return rsay;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = null;
		System.out.println(Arrays.toString(new Solution().productExceptSelf(nums)));
	}

}
