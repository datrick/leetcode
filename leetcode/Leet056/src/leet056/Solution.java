package leet056;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {

	//Definition for an interval.
	public static class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public static class IntervalComparator implements Comparator<Interval> {
		public int compare(Interval i1, Interval i2){
			if (i1.start < i2.start || (i1.start == i2.start && i1.end < i2.end))
				return -1;
			if (i1.start == i2.start && i1.end == i2.end)
				return 0;
			return 1;
		}
	}
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals.size() <= 1)
			return intervals;
		intervals.sort(new IntervalComparator());
		for (int i = 0; i < intervals.size(); i ++){
			while (i + 1 < intervals.size() && intervals.get(i + 1).start <= intervals.get(i).end){
				intervals.get(i).end = Math.max(intervals.get(i + 1).end, intervals.get(i).end);
				intervals.remove(i + 1);
			}
		}
		return intervals;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution obj = new Solution();
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 4));
		intervals.add(new Interval(2, 3));
//		intervals.add(new Interval(15, 18));
//		intervals.add(new Interval(1, 3));
		for (Interval i : intervals)
			System.out.format("[%d, %d], ", i.start, i.end);
		System.out.println("");
		intervals = obj.merge(intervals);
		for (Interval i : intervals)
			System.out.format("[%d, %d], ", i.start, i.end);
		System.out.println("");
	}

}
