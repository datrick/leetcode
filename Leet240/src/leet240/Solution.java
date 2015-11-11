package leet240;

public class Solution {

	boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0)
			return false;
		if (matrix[0].length == 0)
			return false;
		int lx = 0, ly = 0, rx = matrix.length - 1, ry = matrix[0].length - 1;
		return this.doSearch(matrix, target, lx, ly, rx, ry);
	}

	boolean doSearch(int[][] m, int t, int lx, int ly, int rx, int ry) {
		if (lx > rx || ly > ry)
			return false;
		if (t > m[rx][ry] || t < m[lx][ly])
			return false;
		if (lx == rx && ly == ry)
			if (t == m[lx][ly])
				return true;
			else
				return false;
		int mx = (lx + rx + 1) / 2, my = (ly + ry + 1) / 2;
		if (t == m[mx][my])
			return true;
		if (t < m[mx][my]) {
			if (doSearch(m, t, lx, ly, mx - 1, my - 1) || doSearch(m, t, lx, my, mx - 1, ry) || doSearch(m, t, mx, ly, rx, my - 1))
				return true;
			else
			return false;
		} else {
			if (doSearch(m, t, lx, my + 1, mx - 1, ry) || doSearch(m, t, mx + 1, ly, rx, my - 1) || doSearch(m, t, mx, my, rx, ry))
				return true;
			else
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] matrix = {
//				{1,   4,  7, 11, 15},
//				{2,   5,  8, 12, 19},
//				{3,   6,  9, 16, 22},
//				{10, 13, 14, 17, 24},
//				{18, 21, 23, 26, 30}
//		};
		int[][] matrix = {};
		int target = 30;
		System.out.println(new Solution().searchMatrix(matrix, target));
	}

}
