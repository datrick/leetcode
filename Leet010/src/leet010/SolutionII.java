package leet010;

public class SolutionII {
	public boolean isMatch(String s, String p) {
		int lens = s.length(), lenp = p.length(), i, j;
		boolean[][] A = new boolean[3][lens + 1];
		A[0][0] = true;
		for (i = 1; i <= lens; i ++)
			A[0][i] = false;
		for (i = 1; i <= lenp; i ++) {
			A[i % 3][0] = p.charAt(i - 1) == '*' && A[(i - 2) % 3][0] ? true : false;
			for (j = 1; j <= lens; j ++) {
				if (p.charAt(i - 1) == '*') {
					if (p.charAt(i - 2) == '*')
						A[i % 3][j] = A[(i - 1) % 3][j];
					else {
						if (A[(i - 2) % 3][j])
							A[i % 3][j] = true;
						else {
							if (A[i % 3][j - 1] && (p.charAt(i - 2) == '.' || p.charAt(i - 2) == s.charAt(j - 1)))
								A[i % 3][j] = true;
							else
								A[i % 3][j] = false;
						}
					}
				} else {
					if ((p.charAt(i - 1) == '.' || p.charAt(i - 1) == s.charAt(j - 1)) && A[(i - 1) % 3][j - 1])
						A[i % 3][j] = true;
					else
						A[i % 3][j] = false;
				}
			}
//			if (A[i % 2][lens])
//				return true;
		}
		return A[lenp % 3][lens];
	}
}
