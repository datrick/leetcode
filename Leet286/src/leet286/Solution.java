package leet286;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	private static final int INF = 2147483647;
	public void wallsAndGates(int[][] rooms) {
		if (rooms.length <= 0)
			return;
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < rooms.length; i ++)
			for (int j = 0; j < rooms[0].length; j ++)
				if (rooms[i][j] == 0) {
					queue.offer(i);
					queue.offer(j);
				}
		while (! queue.isEmpty()) {
			int x = queue.poll(), y = queue.poll();
			for (int i = -1; i <= 1; i ++)
				for (int j = -1; j <= 1; j ++) {
					if ((! (i + j == 1 || i + j == -1) ) || x + i < 0 || x + i >= rooms.length ||
							y + j < 0 || y + j >= rooms[0].length)
						continue;
					if (rooms[x + i][y + j] == INF) {
						rooms[x + i][y + j] = rooms[x][y] + 1;
						queue.offer(x + i);
						queue.offer(y + j);
					}
				}
		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] rooms = { {INF, -1, 0, 1}, {INF, INF, INF, -1}, {INF, -1, INF, -1}, {0, -1, INF, INF} };
		Solution obj = new Solution();
		obj.wallsAndGates(rooms);
		System.out.println(Arrays.deepToString(rooms));
	}

}
