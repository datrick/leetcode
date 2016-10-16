package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class Leet398 {
	private int[] nums;
	private Random random;
	public Leet398(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }
    
    public int pick(int target) {
        int num = 0, idx = -1;
        for (int i = 0; i < this.nums.length; i ++) {
        	if (target == this.nums[i]) {
        		if (this.random.nextInt(++ num) == 0) {
        			idx = i;
        		}
        	}
        }
        return idx;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 4};
		Leet398 obj = new Leet398(nums);
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < 1000; i ++) {
			int j =obj.pick(3);
			if (!map.containsKey(j)) {
				map.put(j, 0);
			}
			map.put(j, map.get(j) + 1);
		}
		for (Entry<Integer, Integer> entry: map.entrySet()) {
			System.out.println(entry.getKey() + ": " + (double) entry.getValue() / 1000.0);
		}
	}

}
