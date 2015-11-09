package leet134;

public class Solution {

	public int canCompleteCircuit(int[] gas, int[] cost) {
		if(gas.length == 0)
			return -1;
		int start = gas.length - 1, end = 0, remain = gas[gas.length-1] - cost[gas.length-1];
		while(start != end){
			if(remain >= 0){
				remain += gas[end] - cost[end];
				end ++;
			}
			else{
				start --;
				remain += gas[start] - cost[start];
			}
		}
		if(remain >= 0)
			return start;
		else 
			return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] gas = {4};
		int[] cost = {5};
		Solution obj = new Solution();
		System.out.format("start from station: %d\n", obj.canCompleteCircuit(gas, cost));
	}

}
