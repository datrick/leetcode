package leet060;

import java.util.LinkedList;
import java.util.List;

public class Solution {

	public String getPermutation(int n, int k) {
		int[] pTable = new int[n + 1];
		int i, j, num = 1;
		for (i = 1, pTable[0] = 1; i <= n; i ++){
			pTable[i] = pTable[i - 1] * i;
//			System.out.printf("%d ", pTable[i]);
		}
//		System.out.println("");
		List<Integer> numbers = new LinkedList<Integer>();
		for (i = 0; i <= n; i ++)
			numbers.add(i);
		StringBuilder sb = new StringBuilder();
		while (k > 0){
			for (i = 1; i <= n && k > pTable[i]; i ++) ;
			num = numbers.size() - i;
			for (j = 1; j < num; j ++)
					sb.append(Integer.toString(numbers.remove(1)));
//			System.out.printf("k: %d, i: %d numbers: %s \n",k, i, numbers.toString());
			if (k == pTable[i]){
//				System.out.println(numbers);
				for (j = numbers.size() - 1; j > 0; j --)
					sb.append(Integer.toString(numbers.remove(j)));
				k = 0;
			} else {
				num = (int) Math.ceil((double)k / (double)(pTable[i - 1]));
//				System.out.printf("num: %d\n", num);
//				System.out.println(numbers);
				sb.append(Integer.toString(numbers.remove(num)));
				k = k % pTable[i - 1];
//				System.out.println(numbers);
//				System.out.println(k);
				if (k == 0)
					for (j = numbers.size() - 1; j >= 1; j --)
						sb.append(Integer.toString(numbers.get(j)));
			}
		}
		return sb.toString();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionII obj = new SolutionII();
		int factorial = 1, n = 5;
		for (int i = 1; i <= n; i ++)
			factorial *= i;
		System.out.println(factorial);
		for (int i = 1; i <= factorial; i ++)
			System.out.println(obj.getPermutation(n, i));
	}

}
