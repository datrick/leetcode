package amazonOA1;

public class Day {
	//the time complexity is O(day * input.length), space complexity is O(1)
	//to calculate the result of next day:
	//let pre denote the value of the (i - 1)th element in the array of current day, next denote the value of next element of current day
	//the next value of current element is determined by comparing pre and next
	//record the current value of the current element as pre, and update the current element to its next value
	//iterate through the array to calculate the next value of each element
	public static int[] day(int[] input, int day){
		if (input == null || input.length <= 0)
			return input;
		if (input.length == 1) {
			input[0] = 0;
			return input;
		}
		int pre = 0, next = 0, cur = 0;
		for (int i = 0; i < day; i ++) {
			pre = 0;
			for (int j = 0; j < input.length; j ++) {
				next = j + 1 < input.length ? input[j + 1] : 0;
				cur = pre == next ? 0 : 1;
				pre = input[j];
				input[j] = cur;
			}
		}
		return input;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
