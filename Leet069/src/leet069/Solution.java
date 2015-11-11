package leet069;

public class Solution {

	public int sqrtHelper(int x, int start, int end) {
		int mid, result = (start + end) / 2;
		while(start <= end){
			mid = (start + end ) / 2;
			if (mid * mid == x)
				return mid;
			else {
				if (mid * mid < x){
					result = mid;
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return result;
	}
	
	public int sqrt(int x) {
//		if (x == 0)
//			return 0;
//		if (x < 40000)
//			return this.sqrtHelper(x, 1, x);
//		int numOfDigits = 0, start = 1, end = x;
//		while(end >= 40000 || numOfDigits % 2 == 1){
//			end = end / 10;
//			numOfDigits += 1;
//		}
//		System.out.println(end);
//		start = (int) (this.sqrtHelper(end, 1, end) * Math.pow(10, (numOfDigits / 2)));
//		System.out.printf("start: %d, end: %d\n", start, (int) Math.sqrt(Integer.MAX_VALUE));
//		return this.sqrtHelper(x, start, (int) Math.sqrt(Integer.MAX_VALUE));
		int i = x, j;
		while (i > 0){
			j = (i + x / i) / 2;
			if(j >= i)
				return i;
			i = j;
		}
		return i;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.MAX_VALUE);
		Solution obj = new Solution();
		for (int i = 0; i <= 10; i ++)
			System.out.format("i: %d, sqrt: %d\n", i, obj.sqrt(i));
		System.out.println(obj.sqrt(2147395599));
	}
}
