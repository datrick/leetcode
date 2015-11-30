package phoneInterview;

import java.util.Arrays;

public class Tickets {

	public static int maxProfit(int[] counter, int m) {
		if (counter == null || counter.length <= 0)
			return 0;
		if (counter.length == 1)
			return (m * (counter[0] + counter[0] - m + 1)) / 2;
		int n = 0, max, cur, len = counter.length - 1;
		Arrays.sort(counter);
		max = counter[len];
		for (int v: counter)
			System.out.print(v);
		for (cur = len - 1; cur >= 0 && counter[cur] == max; cur --);
		System.out.printf("%d: %d%n", cur, max);
		while (cur >= 0 && m > 0) {
			System.out.printf("%d: %d%n", cur, m);
			int delta = max - counter[cur];
			int l = len - cur;
			if (delta * l >= m) {
				int t = m / l;
				m -= t * l;
				n += l * (max + max - t + 1) * t / 2 + m * (max - t);
				m = 0;
			} else {
				m -= delta * l;
				n += l * (max + max - delta + 1) * delta / 2;
				max = counter[cur];
				while (cur >= 0 && counter[cur] == max)
					cur --;
			}
		}
		return n;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] counter = {3, 2, 5, 7, 6, 2};
		System.out.println(Tickets.maxProfit(counter, 5));
	}

}
