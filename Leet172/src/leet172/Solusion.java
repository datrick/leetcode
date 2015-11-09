package leet172;

public class Solusion {

	public int trailingZeroes(int n) {
		int num2 = 0, num5 = 0, temp = n;
		while(temp > 0){
			temp /= 2;
			num2 += temp;
		}
		temp = n;
		while(temp > 0){
			temp /= 5;
			num5 += temp;
		}
		return Math.min(num2, num5);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solusion obj = new Solusion();
		for(int i = 0; i < 5; i ++)
			System.out.format("%d\n", obj.trailingZeroes(10 * i));
	}

}
