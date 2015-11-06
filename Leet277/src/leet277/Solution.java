package leet277;

public class Solution {

	private boolean knows(int a, int b) {
		return a > b;
	}
	public int findCelebrity(int n) {
		int i = 0, j = 1;
		while (i < n - 1) {
			for (j = i + 1; j < n; j ++)
				if (! knows(j, i)) {
					i = j;
					break;
				}
			if (j == n)
				break;
		}
		
		for (j = 0; j < n; j ++) {
			if (j != i && (knows(i, j) || !knows(j, i)))
					return -1;
		}
		return i;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().findCelebrity(2));
	}

}
