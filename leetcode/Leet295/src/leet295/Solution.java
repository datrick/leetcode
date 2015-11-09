package leet295;

import java.util.PriorityQueue;

public class Solution {

	private static final int CAPACITY = 1000;
	private PriorityQueue<Integer> maxQ = new PriorityQueue<Integer>(CAPACITY, (a, b) -> Integer.compare(b, a)),
			minQ = new PriorityQueue<Integer>(CAPACITY, (a, b) -> Integer.compare(a, b));
	// Adds a number into the data structure.
	public void addNum(int num) {
		if (minQ.size() == maxQ.size()) {
			minQ.add(num);
			maxQ.add(minQ.poll());
		} else {
			maxQ.add(num);
			minQ.add(maxQ.poll());
		}
	}

	// Returns the median of current data stream
	public double findMedian() {
		if (maxQ.size() == 0)
			return 0;
		if (maxQ.size() == minQ.size())
			return ((double) maxQ.peek() + (double) minQ.peek()) / 2;
		else
			return (double) maxQ.peek();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Solution obj = new Solution();
		for (int i = 0; i < nums.length; i ++) {
			System.out.println(obj.findMedian());
			obj.addNum(nums[i]);
		}
	}

}
