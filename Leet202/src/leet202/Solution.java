package leet202;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public boolean isHappy(int n) {
		Set<Integer> visited = new HashSet<>();
		while (true) {
			if (n == 1)
				return true;
			if (visited.contains(n)) 
				return false;
			visited.add(n);
			int next = 0;
			while (n > 0) {
				next += (n % 10) * (n % 10);
				n /= 10;
			}
			n = next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().isHappy(18));
	}

}
