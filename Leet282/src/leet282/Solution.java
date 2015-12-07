package leet282;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
	
	private int priority(char c) {
		if (c == '*')
			return 1;
		return 0;
	}
	
	private int calculate(int a, int b, char c) {
		if (c == '*')
			return a * b;
		if (c == '+')
			return a + b;
		if (c == '-')
			return b - a;
		return 0;
	}
	public int evaluateExp(String s) {
		if (s == null || s.length() <= 0)
			return 0;
		Stack<Integer> stn = new Stack<>();
		Stack<Character> sto = new Stack<>();
		for (int i = 0; i < s.length(); ) {
			char c = s.charAt(i);
			if (c >= '0' && c <= '9') {
				int j = i;
				while (j < s.length() && s.charAt(j) <= '9' && s.charAt(j) >= '0')
					j ++;
				//System.out.format("%d: %c, %d: %c", i, s.charAt(i), j, s.charAt(j));
				stn.push(Integer.valueOf(s.substring(i, j)));
				
				i = j;
			} else {
				while (! sto.isEmpty() && priority(c) <= priority(sto.peek()))
					stn.push(calculate(stn.pop(), stn.pop(), sto.pop()));
				sto.push(c);
				i ++;
			}
		}
		while (!sto.isEmpty())
			stn.push(calculate(stn.pop(), stn.pop(), sto.pop()));
		return stn.pop();
	}
	
	public void recurAdd(String num, int i, List<String> exp, List<String> rslt, int target) {
		String[] op = {"+", "-", "*"};
		for (int j = i + 1; j <= num.length(); j ++) {
			String test = num.substring(i, j);
			long l = Long.valueOf(test);
			if (l > Integer.MAX_VALUE)
				break;
			exp.add(num.substring(i, j));
			if (j < num.length()){
				for (String s: op) {
					exp.add(s);
					recurAdd(num, j, exp, rslt, target);
					exp.remove(exp.size() - 1);
				}
			}else {
					StringBuilder sb = new StringBuilder();
					for (String t: exp)
						sb.append(t);
					//System.out.println(sb.toString());
					if (this.evaluateExp(sb.toString()) == target)
						rslt.add(sb.toString());
			}
			exp.remove(exp.size() - 1);
			if (num.charAt(i) == '0')
				return;
		}
	}

	public List<String> addOperators(String num, int target) {
		
		List<String> rslt = new ArrayList<>(), exp = new LinkedList<>();
		this.recurAdd(num, 0, exp, rslt, target);
		return rslt;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "232";
		SolutionII obj = new SolutionII();
		//System.out.println(obj.evaluateExp(s));
		//s = "105";
		List<String> rslt = obj.addOperators(s, 8);
		for (String t: rslt)
			System.out.println(t);
	}

}
