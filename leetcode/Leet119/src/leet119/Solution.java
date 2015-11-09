package leet119;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public List<Integer> getRow(int rowIndex) {
		Integer[] result = new Integer[rowIndex + 1];
		result[0] = 1;
		int i, j;
		for(i = 0; i <= rowIndex; i ++){
			for(j = i - 1; j > 0; j --)
				result[j] = result[j] + result[j - 1];
			result[i] = 1;
		}
		return new ArrayList<Integer>(Arrays.asList(result));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution obj = new Solution();
		for(Integer x : obj.getRow(4))
			System.out.format("%d, ", x);
	}

}
