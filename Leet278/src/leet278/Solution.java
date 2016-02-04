package leet278;

public class Solution {


	boolean isBadVersion(int version) {
		return version >= 1702766719;
	}
	
	public int firstBadVersion(int n) {
		if (!isBadVersion(n))
			return n + 1;
		int s = 1, e = n;
		while (s < e) {
			int m = (int) (((long) s + (long)e) / 2) % Integer.MAX_VALUE;
			if (isBadVersion(m))
				e = m;
			else
				s = m + 1;
		}
		return e;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().firstBadVersion(2126753390));
	}

}
