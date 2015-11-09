package leet274;

public class SolutionII {

	public int hIndex(int [] citations) {
		int[] count = new int[citations.length + 1];
		int n = citations.length;
		for (int i: citations) {
			i = i > n ? n : i;
			count[i] ++;
		}
		for (int i = count.length - 1, pre = 0; i >= 0; i --) {
			count[i] += pre;
			if (count[i] >= i)
				return i;
			pre = count[i];
		}
		return 0;
	}
}
