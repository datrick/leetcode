package leet327;

public class SolutionII {

	private int doCounting(int[] nums, int s, int e, int lower, int upper) {
		if (s == e)
			return nums[s] <= upper && nums[s] >= lower ? 1 : 0;
		int m = (s + e) / 2;
		int left = doCounting(nums, s, m, lower, upper), right = doCounting(nums, m + 1, e, lower, upper);
		int res = 0, l = e, u = e;
		for (int i = s; i <= m; i ++) {
			while (nums[i] 
		}
	}
	public int countRangeSum(int[] nums, int lower, int upper) {
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
