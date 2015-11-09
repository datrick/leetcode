package leet241;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	private boolean isOperator(char c) {
		if (c == '+' || c == '-' || c == '*')
			return true;
		return false;
	}
	
	private int calculate(int p, int q, char c) {
		if (c == '+')
			return p + q;
		if (c == '-')
			return p - q;
		if (c == '*')
			return p * q;
		return 0;
	}
	
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> rslt = new ArrayList<>();
		int len = input.length();
		if (len <= 0)
			return rslt;
		int start = 0, end = 0;
		List<Integer> operands = new ArrayList<>();
		List<Character> operators = new ArrayList<>();
		while (end < len) {
			char c = input.charAt(end);
			if (isOperator(c)) {
				operators.add(new Character(c));
				operands.add(Integer.valueOf(input.substring(start, end)));
				start = end + 1;
			}
			end += 1;
		}
		operands.add(Integer.valueOf(input.substring(start, end)));
		List<List<List<Integer>>> Opt = new ArrayList<>();
		for (int i = 0; i < operands.size(); i ++) {
			Opt.add(new ArrayList<>());
			for (int j = 0; j < operands.size(); j ++)
				Opt.get(i).add(new ArrayList<>());
		}
		for (int i = 0; i < operands.size(); i ++)
			Opt.get(i).get(i).add(operands.get(i));
		for (int i = 1; i < operands.size(); i ++)
			for (int j = 0; j + i < operands.size(); j ++)
				// calculate the possible values from j to i + j
				for (int k = j; k < j + i; k ++) {
					for (int p : Opt.get(j).get(k))
						for (int q: Opt.get(k + 1).get(j + i)){
							int res = calculate(p, q, operators.get(k));
							Opt.get(j).get(j + i).add(res);
						}
				}
		for (int p : Opt.get(0).get(operands.size() - 1))
			rslt.add(p);
		return rslt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "2*3-4*5-1";
		List<Integer> rslt = new Solution().diffWaysToCompute(input);
		for (int i: rslt)
			System.out.printf("%d ", i);
	}

}
