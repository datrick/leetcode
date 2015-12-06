package leet313;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {

//	private static class Pair {
//		public long base;
//		public int idx;
//		public long val;
//		public Pair(long b, int i, long v) {
//			base = b;
//			idx = i;
//			val = v;
//		}
//	}
	public int nthSuperUglyNumber(int n, int[] primes) {
		if (n <= 1 || primes == null || primes.length <= 0)
			return 1;
		PriorityQueue<Long> queue = new PriorityQueue<Long>(n, (a, b) -> Long.compare(b, a)), q2 = new PriorityQueue<Long>();
		Set<Long> set = new HashSet<>();
		queue.offer((long) 1);
		set.add((long) 1);
		q2.offer((long) 1);
		Long curv = q2.poll();
		int idx = 0;
		while (queue.size() < n) {
			if (idx < primes.length) {
				long newv = curv * primes[idx ++];
				if (! set.contains(newv)) {
					queue.add(newv);
					q2.offer(newv);
					set.add(newv);
				}
			}
			else {
				curv = q2.poll();
				idx = 0;
			}
		}

		while (! (curv * primes[0] >= queue.peek())) {
			for (idx = 0; idx < primes.length; idx ++) {
				long val = curv * primes[idx];
				if (val >= queue.peek())
					break;
				if (set.contains(val))
					continue;
				queue.offer(val);
				set.add(val);
				q2.offer(val);
				queue.poll();
			}
			curv = q2.poll();
		}
		return (int) (queue.peek() % Integer.MAX_VALUE);
	}
//		PriorityQueue<Pair> queue = new PriorityQueue<Pair>(n, (a, b) -> Long.compare(a.val, b.val));
//		queue.offer(new Pair(1, 0, 1 * (long) primes[0]));
//		long pre = 1, val = 1, newv = 1;
//		for (int i = 1; i < n; ) {
//			Pair p = queue.poll();
//			val = p.val;
//			queue.offer(new Pair(p.val, 0, p.val * (long) primes[0]));
//			//System.out.format("%d ", val);
//			if (p.idx + 1 < primes.length) {
//				p.val = p.base * primes[p.idx + 1];
//				p.idx ++;
//				queue.offer(p);
//			}
//			if (val != pre) {
//				pre = val;
//				i ++;
//			}
//			for (base = val / primes[idx], j = idx + 1; j < primes.length; j ++) {
//				if (! map.containsKey(base * primes[j])) {
//					map.put(base * primes[j], j);
//					queue.offer(base * primes[j]);
//					break;
//				}
//			}
//			for (j = 0; j < primes.length; j ++) {
//				if (! map.containsKey(val * primes[j])) {
//					map.put(val * primes[j], j);
//					queue.offer(val * primes[j]);
//					break;
//				}
//			}
//		}
//		return (int) val;
//	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] primes = {2, 7, 13, 19};
		int[] primes = {2,3,5,13,19,29,31,41,43,53,59,73,83,89,97,103,107,109,127,137,139,149,163,173,179,193,197,199,211,223,227,229,239,241,251,257,263,269,271,281,317,331,337,347,353,359,367,373,379,389,397,409,419,421,433,449,457,461,463,479,487,509,521,523,541,547,563,569,577,593,599,601,613,619,631,641,659,673,683,701,709,719,733,739,743,757,761,769,773,809,811,829,857,859,881,919,947,953,967,971};
		System.out.println(new Solution().nthSuperUglyNumber(1000000, primes));
	}

}
