package leet154;

public class Solusion {

	public int findMin(int[] num) {
		int l = 0, r = num.length - 1, m = (l + r) / 2;
		int j = 0;
		while(l < r){
			
			if(l + 1 == r)
				return(Math.min(num[l], num[r]));
			m = (l + r) / 2;
			//lth and mth elements are in the same section
			if(num[l] < num[m]){
				if(num[r] >= num[m])
					return num[l];
				else{
					l = m;
					continue;
				}
			}
			//lth and mth elements are in different sections
			if(num[l] > num[m]){
				r = m;
				continue;
			}
			//lth and mth elements are equal
			if(num[l] == num[m]){
				System.out.format("%d, %d, %d\n", l, m, r);
				if(num[r] > num[m])
					return num[m];
				if(num[r] < num[m]){
					l = m;
					continue;
				}
				if(num[r] == num[m]){
					System.out.println("even");
					for(j = l; j < m;j ++){
						System.out.format("jth: %d, lth: %d, mth: %d\n", num[j], num[l], num[m]);
						if(num[j] < num[l])
							return num[j];
						if(num[j] > num[l]){
							l = j;
							r = m;
							break;
						}
					}
					if(j == m){
						l = m;
						continue;
					}
				}
			}
		}
		return num[l];
	}
	public static void main(String[] args) {
		Solusion obj = new Solusion();
		int[] num = {10,1,10,10,10};
		System.out.println(obj.findMin(num));
		// TODO Auto-generated method stub

	}

}
