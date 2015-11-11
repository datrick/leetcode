package leet189;

import java.math.BigInteger;

public class Solution {

	private static int GCD(int a, int b) {
		return (BigInteger.valueOf(a).gcd(BigInteger.valueOf(b))).intValue();
	}
	
	public void rotate(int[] nums, int k) {
		int n = nums.length;
		k %= n;
		if (k == 0 || n <= 1)
			return;
		int count = Solution.GCD(n, k);
		for (int i = 0; i < count; i ++) {
			int j = i, current = nums[j], target = j + k;
			while (true) {
				if (target >= n)
					target -= n;
				int next = nums[target];
				nums[target] = current;
				current = next;
				j = target;
				if (target == i)
					break;
				target += k;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		for (int k = 0; k < 10; k ++) {
			new Solution().rotate(nums, 1);
			for (int i : nums) 
				System.out.format("%d ", i);
			System.out.println("");
		}
	}

}
