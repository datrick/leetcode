package leet281;

import java.util.ArrayList;
import java.util.List;

public class ZigzagIterator {

	private List<Integer> zigzagList = new ArrayList<>();
	private int pos;
	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		List<List<Integer>> lists = new ArrayList<>();
		lists.add(v1);
		lists.add(v2);
		int[] pos = new int[lists.size()];
		int i = 0;
		while (!lists.isEmpty()) {
			if (pos[i] >= lists.get(i).size()) {
				lists.remove(i);
			} else {
				zigzagList.add(lists.get(i).get(pos[i]));
				pos[i] ++;
				i ++;
			}
			if (i >= lists.size())
				i = 0;
		}
		this.pos = 0;
		System.out.println(this.zigzagList);
	}

	public int next() {
		return pos >= zigzagList.size() ? -1 : zigzagList.get(pos ++);
	}

	public boolean hasNext() {
		return pos < zigzagList.size();
	}
	
	public static void main(String[] args) {
		int[] a1 = {1, 3}, a2 = {2};
		List<Integer> v1 = new ArrayList<>(), v2 = new ArrayList<>();
		for (int v: a1)
			v1.add(v);
		for (int v: a2)
			v2.add(v);
		System.out.println(v2);
		ZigzagIterator it = new ZigzagIterator(v1, v2);
		while (it.hasNext())
			System.out.print(it.next() + ", ");
		
	}
}
