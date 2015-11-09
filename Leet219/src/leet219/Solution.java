package leet219;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (k <= 0)
			return false;
		Set<Integer> set = new HashSet<>(k + 1);
		for (int i = 0; i < nums.length; i ++) {
			if (set.contains(nums[i]))
				return true;
			else
				set.add(nums[i]);
			if (i - k >= 0)
				set.remove(nums[i - k]);
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 1, 9};
		System.out.println(new Solution().containsNearbyDuplicate(nums, 6));
	}

}
