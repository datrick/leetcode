package leet264;

public class Solution {

	private static class Factor {
		public int base, index;
		public Factor(int base, int index) {
			this.base = base;
			this.index = index;
		}
	}
	
	public int nthUglyNumber(int n) {
		int len = Math.max(n, 4), i = 1, min = 0;
		int[] uglyNumbers = new int[len + 4];
		uglyNumbers[1] = 1;
		Factor[] factors = new Factor[3];
		factors[0] = new Factor(2, 1);
		factors[1] = new Factor(3, 1);
		factors[2] = new Factor(5, 1);
		while (i < n) {
			int next = factors[min].base * uglyNumbers[factors[min].index];
			if (next > uglyNumbers[i])
				uglyNumbers[++ i] = next;
			factors[min].index += 1;
			while (factors[0].base * uglyNumbers[factors[0].index] == factors[1].base * uglyNumbers[factors[1].index])
				factors[0].index += 1;
			min = factors[0].base * uglyNumbers[factors[0].index] < factors[1].base * uglyNumbers[factors[1].index] ? 0 : 1;
			while (factors[2].base * uglyNumbers[factors[2].index] == factors[min].base * uglyNumbers[factors[min].index])
				factors[2].index += 1;
			if (factors[2].base * uglyNumbers[factors[2].index] < factors[min].base * uglyNumbers[factors[min].index])
				min = 2;
		}
		return uglyNumbers[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i < 20; i ++)
			System.out.println(new Solution().nthUglyNumber(i));
	}

}
