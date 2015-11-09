package amazon110315;

import java.util.Deque;
import java.util.LinkedList;

public class RoundRobin {
	private static class Job {
		int ts;	//time starting to wait in the queue
		int time;	//remaining required CPU time
		public Job(int t1, int t2) {
			this.ts = t1;
			this.time = t2;
		}
	}
	public static float waitingTimeRobin(int[] arrival, int[] run, int q) {
		if (arrival.length <= 0 || q <= 0)
			return 0;
		Deque<Job> deque = new LinkedList<>();
		int totalTime = 0, t = arrival[0], cur = 0;
		while (!deque.isEmpty() || cur < arrival.length) {
			while (cur < arrival.length && arrival[cur] <= t)
				deque.offer(new Job(arrival[cur], run[cur ++]));
			if (!deque.isEmpty()) {
				Job job = deque.poll();
				totalTime += t - job.ts;
				int step = Math.min(q, job.time);
				t += step;
				job.time -= step;
				if (job.time > 0)
					deque.offer(job);
			}
		}
		return (float) totalTime / (float) arrival.length;
	}
}
