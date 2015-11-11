package leet016;

import java.util.Arrays;

public class Solution {

	public int threeSumClosest(int[] num, int target) {
		if (num.length < 3)
			return 0;
		Arrays.sort(num);
		int pos1 = 0, pos2 = 0, pos3 = 0, err = num[0] + num[1] + num[2] - target;
		while (pos1 <= num.length - 3) {
			for (pos2 = pos1 + 1, pos3 = num.length - 1; pos2 < pos3; ) {
				int sum = num[pos1] + num[pos2] + num[pos3];
				if (Math.abs(sum - target) < Math.abs(err))
					err = sum - target;
				if (sum < target) {
					for (pos2 += 1; pos2 < pos3 && num[pos2] == num[pos2 - 1]; pos2 ++) ;
					continue;
				}
				if (sum > target) {
					for (pos3 -= 1; pos2 < pos3 && num[pos3] == num[pos3 + 1]; pos3 --) ;
					continue;
				}
				if (sum == target)
					return target;
			}
			for (pos1 += 1; pos1 <= num.length - 3 && num[pos1] == num[pos1 - 1]; pos1 ++) ;
		}
		return target + err;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {-1, 2, 1, -4};
		System.out.println(new Solution().threeSumClosest(num, -4));
	}

}
