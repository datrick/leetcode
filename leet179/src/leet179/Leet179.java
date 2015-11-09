package leet179;

import java.lang.Math;
import java.util.Comparator;

public class Leet179 {

	private class myIntegerComparator implements Comparator<Integer>{
		public int compare(Integer int1, Integer int2){
			int l1 = (int)(Math.ceil(Math.log(int1 + 1)));
			int l2 = (int)(Math.ceil(Math.log(int2 + 1)));
			int l3;
			Integer int3, int4;
			while(true){
				if(l1 == l2)
					return (int2 - int1);
				if(l1 > l2){
					l3 = l1 - l2;
					int3 = (int) (int1/Math.pow(10, l3));
					int4 = (int) (int1%Math.pow(10,l3));
					if(int3 != int2)
						return (int2 - int3);
					int1 = int4;
					l1 = l3;
				}else{
					l3 = l2 - l1;
					int3 = (int) (int2/Math.pow(10, l3));
					int4 = (int) (int2%Math.pow(10,l3));
					if(int3 != int1)
						return (int3 - int1);
					int2 = int4;
					l2 = l3;
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
