package leet065;

public class SolutionII {

	public boolean isNumber(String s) {
		int numOfDot = 0, numOfE = 0, start, end = s.length(), numOfNum = 0;
		for (start = 0; start < end && s.charAt(start) == ' '; start ++);
		for (end = s.length(); end > start && s.charAt(end - 1) == ' '; end --);
		if (start >= end)
			return false;
		for(int i = start; i < end; i ++){
			char c = s.charAt(i);
			if ((int) c <= (int) '9' && (int) c >= (int) '0'){
				numOfNum ++;
				continue;
			} 
			if (c == '.'){
				if (!((numOfNum == 0 && (i == end - 1 || s.charAt(i + 1) == 'e' || s.charAt(i + 1) == 'E')) || numOfDot ++ > 0 || numOfE > 0))
					continue;
			}
			if (c == 'e' || c == 'E'){
				if (!(numOfE ++ > 0) && i != start && i != end - 1 && s.charAt(i - 1) != '+' && s.charAt(i - 1) != '-')
					continue;
			}
			if (c == '+' || c == '-')
				if ((i == start || s.charAt(i - 1) == 'E' || s.charAt(i - 1) == 'e') && i != end - 1)
					continue;
			return false;
		}
		return true;
	}
}
