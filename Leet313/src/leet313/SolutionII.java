package leet313;

import java.util.PriorityQueue;

public class SolutionII {

	public int nthSuperUglyNumber(int n, int[] primes) {
		int[] idx = new int[primes.length];
		int[] ugly = new int[n];
		ugly[0] = 1;
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(primes.length, (a, b) -> Integer.compare(
				primes[a] * ugly[idx[a]], primes[b] * ugly[idx[b]]));
		for (int i = 0; i < primes.length; i ++)
			queue.offer(i);
		for (int i = 1; i < ugly.length; ) {
			int j = queue.poll();
			int val = primes[j] * ugly[idx[j] ++];
			if (val > ugly[i - 1])
				ugly[i ++] = val;
			if (primes[j] * ugly[idx[j]] > 0)
				queue.offer(j);
		}
		return ugly[n - 1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] primes = {2,3,5,13,19,29,31,41,43,53,59,73,83,89,97,103,107,109,127,137,139,149,163,173,179,193,197,199,211,223,227,229,239,241,251,257,263,269,271,281,317,331,337,347,353,359,367,373,379,389,397,409,419,421,433,449,457,461,463,479,487,509,521,523,541,547,563,569,577,593,599,601,613,619,631,641,659,673,683,701,709,719,733,739,743,757,761,769,773,809,811,829,857,859,881,919,947,953,967,971};
		int[] primes = {2, 7, 13, 19};
		System.out.println(new Solution().nthSuperUglyNumber(12, primes));
	}

}
