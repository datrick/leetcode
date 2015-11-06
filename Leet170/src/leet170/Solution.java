package leet170;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	private Map<Integer, Integer> map = new HashMap<>();
	private List<Integer> list = new ArrayList<>();
	// Add the number to an internal data structure.
	public void add(int number) {
		if (this.map.containsKey(number))
			this.map.put(number, this.map.get(number) + 1);
		else
			this.map.put(number, 1);
		list.add(number);
	}

	// Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
		for (int i: this.list)
			if (value == i * 2 && map.get(i) >= 2 || value != i * 2 && map.containsKey(value - i))
				return true;
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution obj = new Solution();
		obj.add(1);
		obj.add(2);
		obj.add(5);
		System.out.println(obj.find(7));
	}

}
