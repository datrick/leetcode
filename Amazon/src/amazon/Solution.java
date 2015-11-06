package amazon;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

	static private class CPoint {
		public double x;
		public double y;
		public CPoint(double i, double j) {
			x = i;
			y = j;
		}
	}
	
	static class MyComparator implements Comparator<CPoint>{
		public int compare (CPoint a, CPoint b) {
			double la = a.x * a.x + a.y * a.y, lb = b.x * b.x + b.y * b.y;
			return Double.compare(lb, la);
		}
	}
	
	public static CPoint[] closestk(CPoint[] myList, int k) {
		if (k <= 0)
			return new CPoint[0];
		MyComparator comp = new MyComparator();
		PriorityQueue<CPoint> queue = new PriorityQueue<CPoint>(k, (a, b) -> { return Double.compare(b.x * b.x + 
				b.y * b.y, a.x * a.x + a.y * a.y);} );
		for (int i = 0; i < myList.length && i < k; i ++)
			queue.add(myList[i]);
		for (int i = k; i < myList.length; i ++) {
			if (comp.compare(myList[i], queue.peek()) > 0) {
				queue.poll();
				queue.offer(myList[i]);
			}
		}
		CPoint[] res = new CPoint[queue.size()];
		for (int i = res.length - 1; i >= 0; i --)
			res[i] = queue.poll();
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CPoint[] myList = new CPoint[5];
		myList[1] = new CPoint(1.0, 1.0);
		myList[0] = new CPoint(0.5, 0.5);
		myList[2] = new CPoint(1.5, 1.5);
		myList[3] = new CPoint(0.25, 0.25);
		myList[4] = new CPoint(0.12, 0.11);
		CPoint[] res = Solution.closestk(myList, 3);
		for (CPoint a: res) {
			System.out.format("%f, %f %n", a.x, a.y);
		}
	}

}
