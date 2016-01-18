package leet253;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

	public static class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}

	public int minMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length <= 0)
			return 0;
		
		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start == i2.start ? Integer.compare(i1.end, i2.end) : Integer.compare(i1.start, i2.start);
			}
		});
		int max = 0;
		PriorityQueue<Interval> queue = new PriorityQueue<Interval>(intervals.length, 
				(i1, i2) -> i1.end == i2.end? Integer.compare(i1.start, i2.start) : Integer.compare(i1.end, i2.end));
		for (int i = 0; i < intervals.length; i ++) {
			int s = intervals[i].start;
			while (!queue.isEmpty() && queue.peek().end < s)
				queue.poll();
			queue.offer(intervals[i]);
			max = Math.max(max, queue.size());
		}
		return max;
		
	}
}

