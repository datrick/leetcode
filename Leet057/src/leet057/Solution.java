package leet057;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if (intervals == null)
			intervals = new ArrayList<Interval>();
		if (intervals.size() == 0) {
			intervals.add(newInterval);
			return intervals;
		}
		int i = 0;
		while (i < intervals.size() && intervals.get(i).start < newInterval.start)
			i ++;
		if (i >= 1 && intervals.get(i - 1).end >= newInterval.start) {
			intervals.get(i - 1).end = Math.max(newInterval.end, intervals.get(i - 1).end);
		} else {
			intervals.add(i ++, newInterval);
		}
		while(i < intervals.size()) {
			if (intervals.get(i).start <= intervals.get(i - 1).end) {
				intervals.get(i - 1).end = Math.max(intervals.get(i - 1).end, intervals.get(i).end);
				intervals.remove(i);
			} else
				break;
		}
		return intervals;
	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
