package leet150;

import java.util.Stack;

public class Solusion {

	public int evalRPN(String[] tokens) {
		int[] array = new int[tokens.length];
		int i = 0, e = 0;
		for(i = 0; i < tokens.length; i ++){

			switch(tokens[i]){
			case "+":	array[e-2] = array[e-2] + array[e-1];
			e --;
			break;
			case "-":	array[e-2] = array[e-2] - array[e-1];
			e --;
			break;
			case "*":	array[e-2] = array[e-2] * array[e-1];
			e --;
			break;
			case "/":	array[e-2] = array[e-2] / array[e-1];
			e --;
			break;
			default:	array[e ++] = Integer.parseInt(tokens[i]);
			}
		}
		return array[0];
	}
	public int evalRPNStack(String[] tokens) {
		Stack<Integer> st = new Stack<Integer>();
		int i = 0, op2 = 0;
		String regex = "\\d+";
		for(i = 0; i < tokens.length; i ++){
			if(tokens[i].matches(regex))
				st.push(Integer.parseInt(tokens[i]));
			if(tokens[i].equals("+")){
				if(!st.isEmpty())
					op2 = st.pop();
				if(!st.isEmpty())
					st.push(st.pop() + op2); 
			}
			if(tokens[i].equals("-")){
				if(!st.isEmpty())
					op2 = st.pop();
				if(!st.isEmpty())
					st.push(st.pop() - op2); 
			}
			if(tokens[i].equals("*")){
				if(!st.isEmpty())
					op2 = st.pop();
				if(!st.isEmpty())
					st.push(st.pop() * op2); 
			}
			if(tokens[i].equals("/")){
				if(!st.isEmpty())
					op2 = st.pop();
				if(!st.isEmpty())
					st.push(st.pop() / op2); 
			}
		}
		if(!st.isEmpty())
			return st.pop();
		else
			return Integer.MIN_VALUE;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solusion obj = new Solusion();
		String[] tokens = {"2", "1", "+", "3", "*"};
		System.out.println(obj.evalRPN(tokens));
	}

}
