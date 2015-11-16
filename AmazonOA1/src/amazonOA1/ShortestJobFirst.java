package amazonOA1;

import java.util.PriorityQueue;

public class ShortestJobFirst {
	
	private static class Job implements Comparable<Job> {
		private int time_begin;	//time starting to wait in the queue
		private int time_remain;	//remaining required CPU time
		
		public Job(int time_begin, int time_remain) {
			this.time_begin = time_begin;
			this.time_remain = time_remain;
		}
		public int getTime_b() {
			return this.time_begin;
		}
		public int getTime_r() {
			return this.time_remain;
		}
		@Override
		public int compareTo(Job job2) {
			int equal = Integer.compare(this.time_remain, job2.time_remain);
			return equal == 0 ? Integer.compare(this.time_begin, job2.time_begin) : equal;
		}
	}
	
	public static float shortestJobFirst(int[] arrival, int[] run) {
		if (arrival.length <= 0)
			return 0;
		PriorityQueue<Job> queue = new PriorityQueue<>();
		int totalTime = 0, t = arrival[0], cur = 0;
		while (!queue.isEmpty() || cur < arrival.length) {
			while (cur < arrival.length && arrival[cur] <= t)
				queue.offer(new Job(arrival[cur], run[cur ++]));
			if (!queue.isEmpty()) {
				Job job = queue.poll();
				System.out.format("time: %d, job_arrival: %d%n", t, job.getTime_b());
				int time_remain = job.getTime_r(), time_begin = job.getTime_b();
				totalTime += t - time_begin;
				t += time_remain;
			} else {
				t = arrival[cur];
			}
		}
		return (float) totalTime / (float) arrival.length;
	}
}
