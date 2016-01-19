package facebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumIntervals {
	static String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	static Map<String, Integer> dict = generateMap();
	static Map<String, Integer> generateMap() {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < months.length; i ++)
			map.put(months[i], i);
		return map;
	}
	List<Integer> toIntIntervals(String[] intervals) {
		List<Integer> rslt = new ArrayList<>();
		for (String interval: intervals) {
			String[] time = interval.split("[\\-\\s]+");
//			for (String s: time)
//				System.out.print(s);
//			System.out.println("");
			int sMonth = dict.get(time[0]), sYear = Integer.valueOf(time[1]),
					eMonth = dict.get(time[2]), eYear = Integer.valueOf(time[3]);
			rslt.add(sYear * 12 + sMonth);
			rslt.add(-1 * (eYear * 12 + eMonth));
		}
		return rslt;
	}
	public int sumOfIntervals(String[] intervals) {
		int sum = 0;
		List<Integer> list = this.toIntIntervals(intervals);
		Collections.sort(list, new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				a = a < 0 ? -1 * a : a;
				b = b < 0 ? -1 * b : b;
				return Integer.compare(a, b);
			}
		});
		System.out.println(list.toString());
		List<Integer> mergedList = new ArrayList<>();
		boolean end = false;
		int i = list.get(0), j = 0;
		for (int k: list) {
			if (end) {
				if (k >= 0) {
					mergedList.add(i);
					mergedList.add(j);
					sum += -j - i;
					i = k;
					end = false;
				} else
					j = k;
			} else {
				if (k < 0) {
					j = k;
					end = true;
				}
			}
		}
		mergedList.add(i);
		mergedList.add(j);
		sum += -j - i;
//		for (int l: mergedList)
//			System.out.print(l + " ");
		return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] intervals = {"Apr 2010 - Dec 2010", "Aug 2010 - Dec 2010", "Jan 2011 - Mar 2013"};
		SumIntervals obj = new SumIntervals();
		System.out.print(obj.sumOfIntervals(intervals) + "\n");
	}

}
