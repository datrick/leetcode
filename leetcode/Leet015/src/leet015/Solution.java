package leet015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> rslt = new ArrayList<>();
		int i = 0, j = 0, k = 0;
		Arrays.sort(num);
		while (i <= num.length - 3){
			for (j = i + 1, k = num.length - 1; j < k; ){
				if (num[i] + num[j] + num[k] < 0){
					for (j += 1; j < k && num[j] == num[j - 1]; j ++) ;
					continue;
				}
				if (num[i] + num[j] + num[k] == 0){
					List<Integer> intList = new ArrayList<Integer>();
					intList.add(num[i]);
					intList.add(num[j]);
					intList.add(num[k]);
					rslt.add(intList);
					for (j += 1; j < k && num[j] == num[j - 1]; j ++) ;
					for (k -= 1; k > j && num[k] == num[k + 1]; k --) ;
					continue;
				}
				if (num[i] + num[j] + num[k] > 0)
					for (k -= 1; k > j && num[k] == num[k + 1]; k --) ;
				continue;
			}
			for (i += 1; i < num.length - 2 && num[i] == num[i - 1]; i ++) ;
		}
		return rslt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> rslt = new Solution().threeSum(num);
		for (List<Integer> intList : rslt)
			System.out.println(intList.toString());
	}

}
