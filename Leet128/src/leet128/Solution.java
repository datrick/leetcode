package leet128;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public int longestConsecutive(int[] num) {
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0;
		for(int i = 0; i < num.length; i ++){
			if(!map.containsKey(num[i])){
				map.put(num[i], 1);
				if(max < 1)
					max = 1;
				if(map.containsKey(num[i] + 1)){
					int end = num[i] + map.get(num[i] + 1);
					int l = map.get(end) + 1;
					map.put(end, l);
					map.put(num[i], l);
					if(l > max)
						max = l;
				}
				if(map.containsKey(num[i] - 1)){
					int start = num[i] - map.get(num[i] - 1);
					int end = num[i] + map.get(num[i]) - 1;
					int l = map.get(end) + map.get(start);
					map.put(end, l);
					map.put(start, l);
					if(l > max)
						max = l;
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {0};
		Solution obj = new Solution();
		System.out.println(obj.longestConsecutive(num));
	}

}
