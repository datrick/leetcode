package leet330;

public class SolutionII {
	public int minPatches(int[] nums, int n) {
		if (nums == null)
			return 0;
		long end = 0, m = (long) n;
		int i = 0, num = 0;
		while (i < nums.length && end < m) {
			if ((long) nums[i] > end + 1) {
				end = end * 2 + 1;
				num ++;
			} else {
				end += (long) nums[i ++];
			}
		}
		while (end < m) {
			end = end * 2 + 1;
			num ++;
		}
		return num;
	}
}
