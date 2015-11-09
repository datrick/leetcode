package leet017;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public List<String> letterCombinations(String digits) {
		List<List<String>> keyMap = new ArrayList<>();
		for (int i = 0, c = (int)'a'; i < 8; i ++){
			List<String> list = new ArrayList<String>();
			for (int j = 0; j < 3; j ++, c ++)
				list.add(Character.toString((char) c));
			if (i == 7 || i == 5)
				list.add(Character.toString((char) c ++));
			keyMap.add(list);
		}
		List<String> rslt = new ArrayList<String>();
		for (int i = 0; i < digits.length(); i ++){
			int index = (int) digits.charAt(i) - (int) '0' - 2;
			if (rslt.isEmpty()){
				rslt.addAll(keyMap.get(index));
			} else {
				List<String> newList = new ArrayList<>();
				for (String s : rslt)
					for (String t : keyMap.get(index))
						newList.add(s + t);
				rslt = newList;
			}
			
		}
		return rslt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String digits = "9";
		System.out.println(new Solution().letterCombinations(digits));
	}

}
