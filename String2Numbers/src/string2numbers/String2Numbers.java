package string2numbers;

import java.util.ArrayList;
import java.util.List;

public class String2Numbers {

	public static char[] dict = new char[26];
	{
		for (int i = 0; i < 26; i ++)
			dict[i] = (char) (i + 'a');
	}
	public String convertStr2Int(String s) {
//		List<Integer> rslt = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		s = s.toLowerCase();
		for (char c: s.toCharArray()) {
			if (c >= 'a' && c <= 'z') {
				int v = (int) c - (int) 'a' + 1;
				sb.append(v);
				if (v < 10)
					sb.append(' ');
				sb.append(" ");
			}
			else
				sb.append("\n");
		}
		return sb.toString();
	}
	
	public String convertNum2Str(int[] list) {
//		List<Integer> rslt = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for (int i: list) {
			char c = String2Numbers.dict[((i + 26 - 1) % 26)];
			sb.append(c);
		}
		return sb.toString().toUpperCase();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "SAME,VDPH,IDENTICAL";
		//String s = "abij,dehi,mnqr,stwx";
		System.out.println(new String2Numbers().convertStr2Int(s));
		System.out.println("");
		int[] list = {12,7,8,17,23,12,6,4,15};
		System.out.println(new String2Numbers().convertNum2Str(list));
	}

}
