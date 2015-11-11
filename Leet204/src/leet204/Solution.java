package leet204;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public int countPrimes(int n) {
		if (n <= 2)
			return 0;
		List<Integer> rslt = new ArrayList<>();
		int i = 2;
		boolean prime = true;
		rslt.add(i ++);
		for ( ; i < n; i += 2) {
			prime = true;
			for (int j = 0; j < rslt.size() && rslt.get(j) <= Math.sqrt(i); j ++) {
				if (i % rslt.get(j) == 0){
					prime = false;
					break;
				}
			}
			if (prime)
				rslt.add(i);
		}
		return rslt.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().countPrimes(10));
	}

}
