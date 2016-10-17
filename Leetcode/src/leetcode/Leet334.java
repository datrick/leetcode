package leetcode;

public class Leet334 {

    public boolean increasingTriplet(final int[] nums) {
        final int[] dp = new int[2];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < dp[0]) {
                dp[0] = nums[i];
            }
            if ((nums[i] > dp[0]) && (nums[i] < dp[1])) {
                dp[1] = nums[i];
            }
            if (nums[i] > dp[1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(final String[] args) {
        final int[] nums = new int[] { 8, 7, 6, 5, 8, 7, 6, 5, 4, 3, 2, 1, 2, 1 };
        System.out.println(new Leet334().increasingTriplet(nums));
    }

}
