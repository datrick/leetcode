package leet031;

public class Solution {

	public void nextPermutation(int[] num) {
		if (num.length <= 1)
			return;
		int i = num.length - 1, indexOfMax = num.length - 1;
		for (i = num.length - 2; i >= 0; i --){
			if (num[i] < num[indexOfMax])
				break;
			else 
				indexOfMax = i;
		}
		if (i >= 0){
			for (int j = i + 1; j < num.length; j ++)
				indexOfMax = num[j] > num[i] ? j : indexOfMax;
			int tmp = num[indexOfMax];
			num[indexOfMax] = num[i];
			num[i] = tmp;
		}
		int start = i + 1, len = num.length - start;
		if (num[start] > num[num.length - 1]){
			for (int j = 0; j < len / 2; j ++){
				int tmp = num[j + start];
				num[j + start] = num[len - 1 - j + start];
				num[len - 1 - j + start] = tmp;
			}
		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1, 2, 1, 3};
		new Solution().nextPermutation(num);
		for (int i = 0; i < num.length; i ++)
			System.out.printf("%d ", num[i]);
		System.out.println("");
	}

}
