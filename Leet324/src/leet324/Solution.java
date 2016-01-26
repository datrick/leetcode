package leet324;

import java.util.Arrays;

public class Solution {
	
	private int mapIndex(int i, int len) {
		if ( i * 2 < len)
			return i * 2;
		return i * 2 - ((len - 1) | 1);
	}
	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	private int kthElement(int[] nums, int k, int s, int e) {
		if (e == s)
			return e;
		int pivot = nums[e], idx = s;
		for (int i = s; i < e; i ++) {
			if (nums[i] < pivot) {
				this.swap(nums, idx ++, i);
			}
		}
		this.swap(nums, e, idx);
		if (idx - s == k)
			return idx;
		if (idx - s < k)
			return kthElement(nums, k - (idx - s + 1), idx + 1, e);
		else
			return kthElement(nums, k, s, idx - 1);
	}
	
	private int findkthIndex(int[] nums, int k) {
		return this.kthElement(nums, k, 0, nums.length - 1);
	}
	public void wiggleSort(int[] nums) {
		if (nums == null || nums.length <= 1)
			return;
		double m = 0.0;
		int len = nums.length;
		if (len % 2 == 0) {
			m = ((double) nums[findkthIndex(nums, len / 2)] + (double) nums[findkthIndex(nums, len / 2 - 1)]) / 2;
		} else
			m = (double) nums[findkthIndex(nums, len / 2)];
//		System.out.println(m);
		int lo = 0, i = 0, hi = len - 1;
		while (i <= hi) {
			if (nums[mapIndex(i, len)] < m)
				swap(nums, mapIndex(i ++, len), mapIndex(lo ++, len));
			else {
				if (nums[mapIndex(i, len)] > m)
					swap(nums, mapIndex(i, len), mapIndex(hi --, len));
				else
					i ++;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4, 5, 5, 6};
		//System.out.println(nums[new Solution().kthElement(nums, 7, 0, nums.length - 1)]);
		new Solution().wiggleSort(nums);
		System.out.println(Arrays.toString(nums));
		
	}

}
