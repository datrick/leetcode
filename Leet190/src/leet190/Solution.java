package leet190;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	private static Map<Integer, Integer> map_4bits = generateMap_4bits();
	private static int mask_4bits = generateMask_4bits();
	private static Map<Integer, Integer> generateMap_4bits() {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 0);
		int m = 4, n = 32, limit = (int) Math.pow(2, m);
		for (int i = 1; i < limit; i ++) {
			int key = i, val = 0, mask = 0x1;
			for (int j = 0; j < m; j ++) {
				val = (val << 1) | (mask & key);
				key >>= 1;
			}
			key = i;
			val <<= (n - m);
			for (int j = 0; j < n / m; j ++) {
//				System.out.printf("%s: %s%n", Integer.toString(key, 2), Integer.toString(val, 2));
				map.put(key, val);
				key <<= m;
				val >>>= m;
			}
		}
		return map;
	}
	
	private static int generateMask_4bits() {
		int i = 0x1, m = 4, res = 0;
		for (int j = 0; j < m; j ++) {
			res <<= 1;
			res |= i;
		}
		return res;
	}
	
	public int reverseBits(int n) {
		int m = 4, b = 32, res = 0, mask = mask_4bits;
		for (int i = 0; i < b / m; i ++) {
			res |= map_4bits.get(mask & n);
			mask <<= m;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution obj = new Solution();
		int res = obj.reverseBits(432614596);
		System.out.println(obj.reverseBits(res));
	}

}
