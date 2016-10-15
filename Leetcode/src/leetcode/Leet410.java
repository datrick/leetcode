package leetcode;

public class Leet410 {

    public int splitArray(final int[] nums, final int m) {
        long s = Integer.MIN_VALUE, e = 0, mid = 0;
        final long[] sums = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            s = Math.max(s, nums[i]);
            sums[i + 1] = sums[i] + nums[i];
        }
        e = sums[sums.length - 1];
        while (s < e) {
            mid = (s + e) / 2;
            if (isValid(sums, m, mid)) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        return (int) e;
    }

    private boolean isValid(final long[] sums, final int m, final long max) {
        int s = 1, e = sums.length - 1, mid = 0, i = 0;
        long cur = max;
        while ((s <= e) && (i < m)) {
            while (s < e) {
                mid = (s + e + 1) / 2;
                if (sums[mid] <= cur) {
                    s = mid;
                } else {
                    e = mid - 1;
                }
            }
            cur = sums[s] + max;
            s++;
            i++;
            e = sums.length - 1;
        }
        if (s <= e) {
            return false;
        }
        return true;
    }

    public static void main(final String[] args) {
        final int[] nums = { 7, 2, 5, 10, 8 };
        final int m = 2;
        System.out.println(new Leet410().splitArray(nums, m));
    }
}
