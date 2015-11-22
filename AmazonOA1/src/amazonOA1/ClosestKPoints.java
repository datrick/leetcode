package amazonOA1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ClosestKPoints {
	
	public static CPoint[] closestK(CPoint[] myList,int k){
		if (myList == null || k <= 0)
			return new CPoint[0];
		PriorityQueue<CPoint> queue = new PriorityQueue<CPoint>(myList.length, (a, b) -> {
				double da = a.x * a.x + a.y * a.y, db = b.x * b.x + b.y * b.y;
				return Double.compare(da, db);} );
		queue.addAll(Arrays.asList(myList));
		CPoint[] result = new CPoint[k];
		for (int i = 0; i < k; i ++)
			result[i] = queue.poll();
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CPoint[] myList = { new CPoint(1.0, 1.0), new CPoint(0.5, 0.5), new CPoint(1.5, 1.5), new CPoint(0.25, 0.5) };
		CPoint[] result = ClosestKPoints.closestK(myList, 3);
		for (CPoint p: result)
			System.out.printf("(%f, %f)%n", p.x, p.y);
	}

}
