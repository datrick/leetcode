package leet149;

import java.util.HashMap;
import java.util.Map;

public class Solusion {

	public int maxPoints(Point[] points) {
		if(points.length <= 2)
			return points.length;
		Map<Double, Integer> map = new HashMap<Double, Integer>();
		double gradient = 0.0;
		int max = 0, same = 1, tMax = 0;
		for(int i = 0; i < points.length; i ++){
			for(int j = i + 1; j < points.length; j ++){
				if(points[i].x == points[j].x && points[i].y == points[j].y)
					same ++;
				else{
					if(points[i].x == points[j].x)
						gradient = Integer.MAX_VALUE;
					else{
						if(points[i].y == points[j].y)
							gradient = 0.0;
						else
							gradient = (double)(points[i].y - points[j].y) / (double)(points[i].x - points[j].x);
					}
					if(map.containsKey(gradient)){
						map.put(gradient, map.get(gradient) + 1);
					}
					else{
						map.put(gradient, 1);
					}
					System.out.format("(%d, %d) and (%d, %d) (%f) is added with a number of %d\n", points[i].x, points[i].y, points[j].x, points[j].y, gradient, map.get(gradient));
					if(map.get(gradient) > max)
						max = map.get(gradient);
				}
			}
			if(max + same > tMax)
				tMax = max + same;
			map.clear();
			max = 0;
			same = 1;
		}
		return tMax;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solusion obj = new Solusion();
		//		Point[] points = {new Point(84,250),new Point(0,0),new Point(1,0),new Point(0,-70),new Point(0,-70),new Point(1,-1),new Point(21,10),new Point(42,90),new Point(-42,-230)};
		Point[] points = {new Point(4,0),new Point(4,-1),new Point(4,5)};
		System.out.println(obj.maxPoints(points));
	}

}
