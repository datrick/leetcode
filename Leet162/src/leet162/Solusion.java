package leet162;

public class Solusion {

	public int findPeakElement(int[] num) {

		boolean ltl = true, ltn = false;
		int n = num.length;
		for(int i = 0; i < n; i ++){
//			ltn = (i == n-1) ? true : (num[i] > num[i+1] ? true : false);
			ltn = (i < n-1 && num[i] < num[i+1]) ? false : true;
			if(ltl && ltn)
				return i;
			ltl = !ltn;
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solusion obj = new Solusion();
		int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 10};
		System.out.format("the peak index is: %d\n", obj.findPeakElement(num));
	}

}
