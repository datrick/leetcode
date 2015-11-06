package leet152;

import java.util.ArrayList;
import java.util.List;

public class Solusion {

	public int[] reduceArray(int[] A){
		List<Integer> list = new ArrayList<Integer>();
		int i = 0, t = 0;
		for(i = 0; i < A.length; i ++){
			if(A[i] <= 0){
				if(t != 0){
					list.add(t);
					t = 0;
				}
				list.add(A[i]);
			}

			if(A[i] > 0){
				if(t == 0)
					t = A[i];
				else
					t *= A[i];
			}
		}
		if(t != 0)
			list.add(t);
		int[] num = new int[list.size()];
		for(i = 0; i < num.length; i ++)
			num[i] = list.get(i);
		/*		System.out.println(list.toString());
		 */		return num;
	}

	public int calMax(int[] A, int l, int r){
		int[][] p = new int[r - l][r - l];
		int i = 0, j = 0, max = 0;
		for(i = 0; i < p.length; i ++)
			p[i][i] = A[i + l];
		for(i = 0; i < p.length; i ++)
			for(j = i + 1; j < p.length; j ++){
				p[i][j] = p[i][j - 1] * A[j + l];
				if(p[i][j] > max)
					max = p[i][j];
			}
		return max;
	}

	public int calMaxWithoutZeros(int[] A, int l, int r){
//		System.out.printf("l: %d, r: %d\n", l, r);
		if(r - l == 1)
			return A[l];
		int i = 0, p1 = 1, pm = 1, p2 = 1, result = 1, ne = 0;

		for(i = l; i < r; i ++){
			if(A[i] > 0)
				result *= A[i];
			if(A[i] < 0){
				if(ne == 0){
					pm = result;
					p1 = result * A[i];
				}
				else{
					if(ne == 1){
						pm = result;
					}
					else{
						pm = pm * result * p2;
					}
				}
				result = 1;
				p2 = A[i];
				ne ++;
			}
			//			System.out.printf("ne: %d, p1: %d, p2: %d, pm: %d\n", ne, p1, p2, pm);
		}
		p2 *= result;
		//		System.out.printf("ne: %d, p1: %d, p2: %d, pm: %d\n", ne, p1, p2, pm);

		if(ne == 1)
			return Math.max(pm, result);
		if(ne % 2 == 0)
			return p1 * pm * p2;
		else{
			if(Math.abs(p1) >= Math.abs(p2))
				return p1 * pm;
			else
				return p2 * pm;
		}
	}

	public int maxProduct(int[] A) {

		if(A.length == 1)
			return A[0];
		int max = Integer.MIN_VALUE, l = 0, r = 0;
		while(l < A.length){
			while(l < A.length && A[l] == 0){
				l ++;
				if(max < 0)
					max = 0;
			}
			if(l >= A.length)
				return max;
			for(r = l + 1; r < A.length && A[r] != 0; r ++);
			if(r < A.length && A[r] == 0){
				if(max < 0)
					max = 0;
			}
			int t = this.calMaxWithoutZeros(A, l, r);
			if(t > max)
				max = t;
			l = r;
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solusion obj = new Solusion();
		int[] num = {3,-1,4};
		System.out.format("result is: %d\n",obj.maxProduct(num));

	}

}
