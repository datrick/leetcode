package amazonOA1;

public class GCD {

	private static int gcd2(int a, int b) {
		int c = 0;
		if (a < b) {
			c = a;
			a = b;
			b = c;
		}
		c = a % b;
		while (c != 0) {
			a = b;
			b = c;
			c = a % b;
		}
		return b;
	}
	public static int gcd(int[] nums) {
		if (nums == null || nums.length <= 0)
			return 1;
		int g = nums[0];
		for (int v: nums)
			g = gcd2(g, v);
		return g;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {18, 6, 10, 4, 100};
		System.out.println(GCD.gcd(nums));
	}

}
