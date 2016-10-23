package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leet325 {

    public int maxSubArrayLen(final int[] nums, final int k) {
        int max = 0;
        final Map<Long, Integer> map = new HashMap<>();
        long sum = 0;
        map.put(sum, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
            if (map.containsKey(sum - k)) {
                max = Math.max((i - map.get(sum - k)), max);
            }
        }
        return max;
    }

    public static void main(final String[] args) {
        final int[] nums = { 1, -1, 5, -2, 3 };
        final int k = 3;
        System.out.println(new Leet325().maxSubArrayLen(nums, k));
    }

}
