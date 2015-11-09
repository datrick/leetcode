package leet201;

public class Solution {

	public int rangeBitwiseAnd(int m, int n) {
		int mask = 0x40000000, res = 0;
		while (mask > 0) {
			if (((m & mask) ^ (n & mask)) == 0x0)
				res |= (m & mask);
			else
				break;
			mask >>= 1;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().rangeBitwiseAnd(5, 7));
	}

}
