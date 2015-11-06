package leet239;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {

	public int[] maxSlidingWindow(int[] nums, int k) {
		if (k == 0 || nums.length == 0)
			return null;
		int[] rsa = new int[nums.length - k + 1];
		Deque<Integer> q = new LinkedList<>();
		for (int i = 0; i < nums.length; i ++) {
			while (! q.isEmpty() && nums[i] >= nums[q.peekLast()])
				q.pollLast();
			q.offerLast(i);
			if (i - q.peekFirst() >= k)
				q.pollFirst();
			if (i >= k - 1)
				rsa[i - k + 1] = nums[q.peekFirst()];
		}
		return rsa;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {7, 2, 4};
		int[] rsa = new Solution().maxSlidingWindow(nums, 2);
		System.out.println(Arrays.toString(rsa));
	}

}
