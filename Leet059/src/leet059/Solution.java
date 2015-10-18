package leet059;

public class Solution {

	public int[][] generateMatrix(int n) {
		int [][] rsay = new int[n][n];
		int num = 0, target = n * n, i = 0, j = 0, dir = 0;
		while(num < target){
			rsay[i][j] = ++ num;
			if (dir % 4 == 0){
				if (j == n - 1 - dir / 4){
					dir ++;
					i ++;
				}
				else
					j ++;
			}
			else if (dir % 4 == 1){
				if (i == n - 1 - dir / 4){
					dir ++;
					j --;
				}
				else
					i ++;
			}
			else if (dir % 4 == 2){
				if (j == dir / 4){
					dir ++;
					i --;
				}
				else
					j --;
			}
			else {
				if (i == 1 + dir / 4){
					dir ++;
					j ++;
				}
				else
					i --;
			}
		}
		return rsay;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution obj = new Solution();
		int n = 3;
		int[][] rsay = obj.generateMatrix(n);
		for (int i = 0; i < n; i ++){
			for (int j = 0; j < n; j ++)
				System.out.format("%d ", rsay[i][j]);
			System.out.println("");
		}
	}

}
