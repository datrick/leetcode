package amazon110315;

import java.util.Deque;
import java.util.LinkedList;

public class RoundRobin {
	private static class Job {
		private int time_remain;	//time starting to wait in the queue
		private int time_begin;	//remaining required CPU time
		public Job(int t1, int t2) {
			this.time_begin = t1;
			this.time_remain = t2;
		}
		public int get_time_remain() {
			return this.time_remain;
		}
		public int get_time_begin() {
			return this.time_begin;
		}
		public void set_time_remain(int time) {
			this.time_remain = time;
		}
		public void set_time_begin(int time) {
			this.time_begin = time;
		}
	}
	public static float waitingTimeRobin(int[] arrival, int[] run, int q) {
		if (arrival == null || run == null || arrival.length <= 0 || q <= 0)
			return 0;
		Deque<Job> deque = new LinkedList<>();
		int totalTime = 0, t = arrival[0], cur = 0;
		while (!deque.isEmpty() || cur < arrival.length) {
			while (cur < arrival.length && arrival[cur] <= t)
				deque.offer(new Job(arrival[cur], run[cur ++]));
			if (!deque.isEmpty()) {
				Job job = deque.poll();
				int time_remain = job.get_time_remain(), time_begin = job.get_time_begin();
				totalTime += t - time_begin; 
				int step = Math.min(q, time_remain); 
				t += step;
				time_remain -= step;
				if (time_remain > 0) {
					job.set_time_begin(t);
					job.set_time_remain(time_remain);
					deque.offer(job);
				}
			} else {
				t = arrival[cur];
			}
		}
		return (float) totalTime / (float) arrival.length;
	}
	public static void main(String[] args) {
		int[] arrival = { 0, 1, 4 }, run = { 5, 2, 3 };
		System.out.println(RoundRobin.waitingTimeRobin(arrival, run, 3));
	}
}
