package leet316;


public class SolutionII {

	public String removeDuplicateLetters(String s) {
		if (s == null || s.length() <= 0)
			return "";
		StringBuilder sb = new StringBuilder();
		char start = (char) ('a' - 1), end = (char) ('z' + 1), pre = start;
		sb.append(start);
		int[] nums = new int[end - start + 1];
		boolean[] selected = new boolean[28];
		for (char c: s.toCharArray()) {
			if (c == pre)
				continue;
			nums[c - start] ++;
			pre = c;
			sb.append(c);
		}
		sb.append(end);
		for (int i = 0, j = 1; i < sb.length(); ) {
			for (j = i + 1; j < sb.length() && nums[sb.charAt(j) - start] > 1; j ++) ;
			if (j < sb.length())
				selected[sb.charAt(j) - start] = true;
			for (int k = j - 1; k > i; k --) {
				if (sb.charAt(k) >= sb.charAt(k + 1) || selected[sb.charAt(k) - start]) {
					nums[sb.charAt(k) - start] --;
					sb.deleteCharAt(k);
					j --;
				} else {
					selected[sb.charAt(k) - start] = true;
				}
			}
			i = j;
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.deleteCharAt(0);
		return sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionII sol = new SolutionII();
		System.out.println(sol.removeDuplicateLetters("ccacbaba"));
	}

}
