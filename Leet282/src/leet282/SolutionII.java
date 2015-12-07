package leet282;

import java.util.ArrayList;
import java.util.List;

public class SolutionII {

	private void recurAdd(String num, String exp, int i, long eval, long mul, int target, String[] op, List<String> rslt) {
		int j = i + 1;
		for (; j <= num.length(); j ++) {
			long v = Long.valueOf(num.substring(i, j)), newv = 0, newm = mul;
			if (v > Integer.MAX_VALUE)
				break;
			if (exp.length() == 0) {
				newv = v;
				newm = v;
			}
			else {
				char o = exp.charAt(exp.length() - 1);
				if (o == '+') {
					newv = eval + v;
					newm = v;
				}
				if (o == '-') {
					newv = eval - v;
					newm = -v;
				}
				if (o == '*') {
					newv = eval - mul + mul * v;
					newm = mul * v;
				}	
			}
			if (j == num.length())
				if (newv == target) {
					rslt.add(exp + v);
					break;
				}
			for (String o: op)
				recurAdd(num, exp + v + o, j, newv, newm, target, op, rslt);
			if (num.charAt(i) == '0')
				break;
		}
	}
	
	public List<String> addOperators(String num, int target) {
		List<String> rslt = new ArrayList<>();
		String[] op = {"+", "-", "*"};
		this.recurAdd(num, "", 0, 0, 0, target, op, rslt);
		return rslt;
	}
}
