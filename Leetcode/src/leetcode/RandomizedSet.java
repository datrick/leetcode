package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class RandomizedSet {

	private Map<Integer, Integer> valMap;
	private Map<Integer, Integer> idxMap;
	private Random random;
	
    /** Initialize your data structure here. */
    public RandomizedSet() {
        valMap = new HashMap<>();
        idxMap = new HashMap<>();
        random = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (valMap.containsKey(val))
        	return false;
        idxMap.put(idxMap.size(), val);
        valMap.put(val, valMap.size());
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!valMap.containsKey(val))
        	return false;
        int idx = valMap.get(val), max = valMap.size() - 1;
        if (idx != max) {
        	int maxVal = idxMap.get(max);
        	valMap.put(maxVal, idx);
        	idxMap.put(idx, maxVal);
        } 
        valMap.remove(val);
        idxMap.remove(max);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
    	int size = idxMap.size();
        return idxMap.get(random.nextInt(size));
    }
    
    public static void main(String[] args) {
		RandomizedSet set = new RandomizedSet();
		int[] nums = {1, 10, 32, 62, 55, 18, 3, 4};
		Map<Integer, Integer> counter = new HashMap<>();
		for (int n: nums) {
			set.insert(n);
			counter.put(n, 0);
		}
		for (int i = 1; i < nums.length; i ++) {
			set.remove(nums[i]);
		}
		for (int i = 0; i < 100000; i ++) {
			int r = set.getRandom();
			counter.put(r, counter.get(r) + 1);
		}
		for (Entry<Integer, Integer> entry: counter.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
}
