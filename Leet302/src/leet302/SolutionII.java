package leet302;

public class SolutionII {

	private boolean isValid(char[][] image, int x, int y) {
		if (x < 0 || x >= image.length || y < 0 || y >= image[0].length)
			return false;
		return true;
	}
	private int findExtreme(char[][] image, int x, int y, int dx, int dy) {
		int a, b, da, db;
		while (isValid(image, x + dx, y + dy)) {
			while (isValid(image, x + dx, y + dy) && image[x + dx][y + dy] == '1') {
				x = x + dx;
				y = y + dy;
			}
			if (dx != 0) {
				a = x;
				b = 0;
				da = 0;
				db = 1;
			} else {
				a = 0;
				b = y;
				da = 1;
				db = 0;
			}
			while (isValid(image, a, b) && isValid(image, a + dx, b + dy) && image[a + dx][b + dy] != '1') {
				a += da;
				b += db;
			}
			if (isValid(image, a, b)) {
				x = a;
				y = b;
			} else
				break;
		}
		return (dx != 0 ? x : y);
	}
	public int minArea(char[][] image, int x, int y) {
		int xl = this.findExtreme(image, x, y, -1, 0),
				xh = this.findExtreme(image, x, y, 1, 0),
				yl = this.findExtreme(image, x, y, 0, -1),
				yh = this.findExtreme(image, x, y, 0, 1);
		return (yh - yl + 1) * (xh - xl + 1);
	}
}
