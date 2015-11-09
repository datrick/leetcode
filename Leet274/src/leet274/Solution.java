package leet274;

import java.util.Arrays;


public class Solution {

	public int hIndex(int [] citations) {
		Arrays.sort(citations);
		int i = 0, j = citations.length - 1, h = 0;
		while (i <= j) {
			int m = (i + j) / 2, n = citations[m], p = citations.length - m;
			if (p == n)
				return n;
			h = Math.max(h, Math.min(p, n));
			if (p > n)
				i = m + 1;
			else
				j = m - 1;
		}
		return h;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] citations = {3, 0, 6, 7, 5};
		System.out.println(new SolutionII().hIndex(citations));
	}

}
