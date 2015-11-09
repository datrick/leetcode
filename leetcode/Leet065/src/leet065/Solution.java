package leet065;

public class Solution {

	public boolean isNumber(String s) {
		int indexOfE = s.indexOf('e') < 0 ? s.indexOf('E') : s.indexOf('e');
		if (indexOfE < 0){
			if(isNumberOrSign(s, 0, s.length()) == 0)
				return true;
		} else {
			System.out.println("with pow");
			if (isNumberOrSign(s, indexOfE + 1, s.length()) == 0){
				System.out.println("pow vailid");
				if (isNumberOrSign(s, 0, indexOfE) == 1 || isNumberOrSign(s, 0, indexOfE) == 0)
					return true;
			}
		}
		return false;
    }
	
	static private int isNumberOrSign(String s, int start, int end){
		System.out.println(s.substring(start, end));
		int i, numOfDot = 0;
		for (; start < end && s.charAt(start) == ' '; start ++);
		for (; end > start && s.charAt(end - 1) == ' '; end --);
		if (start >= end)
			return -1;
		System.out.println(s.substring(start, end));
		if (s.charAt(start) == '+' || s.charAt(start) == '-'){
			if (start == end - 1)
				return 1;
			else {
				start ++;
			}
		}
		System.out.println(s.substring(start, end));
		for (i = start; i < end && s.charAt(i) == ' '; i ++);
		System.out.println(s.substring(i, end));
		int num = 0;
		for(; i < end; i ++){
			char c = s.charAt(i);
			if ((int) c <= (int) '9' && (int) c >= (int) '0'){
				num ++;
			} else {
				if (c == '.'){
					if ((num == 0 && i == end - 1) || numOfDot ++ > 0)
						return -1;
				} else 
					return -1;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionII obj = new SolutionII();
		String s = "+e1";
		System.out.println(obj.isNumber(s));
	}

}
