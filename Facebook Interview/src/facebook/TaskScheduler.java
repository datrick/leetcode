package facebook;

import java.util.HashMap;
import java.util.Map;

public class TaskScheduler {
	
	public int scheduleTasks(int[] tasks, int interval) {
		int cur = 0;
		Map<Integer, Integer> record = new HashMap<>();
		for (int i = 0; i < tasks.length; i ++) {
			if (record.containsKey(tasks[i])) {
				int pos = record.get(tasks[i]);
				cur = Math.max(cur, pos + interval + 1);
			}
			record.put(tasks[i], cur);
			cur += 1;
		}
		return cur;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tasks = {1, 2, 3, 1, 2, 3};
		int interval = 3;
		System.out.println(new TaskScheduler().scheduleTasks(tasks, interval));
	}

}
