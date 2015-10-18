package leet260;

public class Solution {

	private String binaryString(int n) {
		int mask = 0x01;
		StringBuilder sb = new StringBuilder();
		while (mask > 0) {
			if ((mask & n) > 0)
				sb.append(1);
			else
				sb.append(0);
			mask = mask << 1;
		}
		return sb.reverse().toString();
	}
	
	public int[] singleNumber(int[] nums) {
		int mask = 0;
		int[] res = new int[2];
		for (int i: nums)
			mask ^= i;
		mask = (mask ^ (mask - 1)) & mask;
		for (int i: nums)
			if ((mask & i) == 0)
				res[0] ^= i;
			else
				res[1] ^= i;
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 2, 4, 5, 4, 5, 6};
		int[] res = new Solution().singleNumber(nums);
		System.out.format("%d, %d%n", res[0], res[1]);
	}

}
