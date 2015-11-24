package amazonOA1;

import java.util.LinkedHashSet;

public class LRU {

	public static int miss(int[] input, int size){
		if (input == null || input.length <= 0 || size <= 0)
			return 0;
		int missed = 0;
		LinkedHashSet<Integer> lru = new LinkedHashSet<>(size);
		for (int v: input) {
			if (lru.contains(v)) {
				lru.remove(v);
				lru.add(v);
			} else {
				missed ++;
				if (lru.size() == size)
					lru.remove(lru.iterator().next());
				lru.add(v);
			}
		}
		return missed;
	}
	
	public static void main(String[] args) {
		int[] input = {1, 2, 3, 4, 2, 3, 4, 5, 1, 6};
		System.out.println(LRU.miss(input, 4));
	}
		// TODO Auto-generated method stub

}