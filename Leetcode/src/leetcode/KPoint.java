package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KPoint {


	public static Point[] Solution(Point[] array, final Point origin, int k) {
			if(array == null || array.length == 0) {
				return new Point[0];//return new Point[k];
			}
			
			PriorityQueue<Point> pq = new PriorityQueue<Point>(k, new Comparator<Point>() {
				@Override
				public int compare(Point a1, Point a2) {
					double dis2 = getDistance(a2, origin), dis1 = getDistance(a1, origin);
					return Double.compare(dis2, dis1);
				}
			});
			for(int i = 0; i < array.length; i++) {
				// pq.offer(array[i]);
				// if(pq.size() > k) {
				// 	pq.poll();
				// }
				if(pq.size() < k) {
					pq.offer(array[i]);
				} else {
					if(getDistance(pq.peek(), origin) > getDistance(array[i], origin)) {
						pq.poll();
						pq.offer(array[i]);
					}
				}

			}
			//should return in ascending order
			
			int index = pq.size()-1;
			Point[] rvalue = new Point[pq.size()];
			while(!pq.isEmpty()) {
				rvalue[index--] = pq.poll();
			}
			return rvalue;
	}
	public static double getDistance(Point a, Point ori) {
		return Math.sqrt((a.x-ori.x)*(a.x-ori.x) + (a.y-ori.y)*(a.y-ori.y));
	}
}
class Point {
	double x;
	double y;
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}