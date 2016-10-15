package leet332;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public List<String> findItinerary(String[][] tickets) {
		List<String> rslt = new ArrayList<>();
		rslt.add("JFK");
		Map<String, List<String>> map = new HashMap<>();
		for (String[] flight: tickets) {
			if (!map.containsKey(flight[0]))
				map.put(flight[0], new ArrayList<>());
			map.get(flight[0]).add(flight[1]);
		}
		for (String s: map.keySet())
			Collections.sort(map.get(s));
		if (restoreItinerary(rslt, map, tickets.length + 1))
			return rslt;
		return new ArrayList<String>();
	}
	
	private boolean restoreItinerary(List<String> rslt, Map<String, List<String>> map, int n) {
		if (rslt.size() == n)
			return true;
		List<String> destinations = map.get(rslt.get(rslt.size() - 1));
		if (destinations == null)
			return false;
		for (int i = 0; i < destinations.size(); i ++) {
				if (destinations.get(i) != null) {
					rslt.add(destinations.get(i));
					destinations.set(i, null);
					if (restoreItinerary(rslt, map, n))
						return true;
					destinations.set(i, rslt.remove(rslt.size() - 1));
				}
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String[][] tickets = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
		String[][] tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		System.out.println(new Solution().findItinerary(tickets));
	}

}
