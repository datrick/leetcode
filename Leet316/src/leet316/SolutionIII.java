package leet316;

<<<<<<< HEAD
=======
import java.util.Arrays;

>>>>>>> origin/java

public class SolutionIII {

	public String removeDuplicateLetters(String s) {
		if (s == null || s.length() <= 0)
			return "";
		int[] counter = new int[26];
		char[] a = s.toCharArray();
		for (char c: a) {
			counter[c - 'a'] ++;
		}
//		System.out.println(Arrays.toString(counter));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < a.length; ) {
			if (counter[a[i] - 'a'] < 0) {
				i ++;
				continue;
			}
			int idx = i;
			int j = i;
			for (j = i; j < a.length; j ++) {
				if (counter[a[j] - 'a'] < 0)
					continue;
				if (a[j] < a[idx])
					idx = j;
				if (counter[a[j] - 'a'] -- == 1)
					break;
			}
			for (; j > idx; j --) {
				if (j < a.length && counter[a[j] - 'a'] >= 0)
					counter[a[j] - 'a'] ++;
			}
			sb.append(a[idx]);
			counter[a[idx] - 'a'] = -1;
			i = idx + 1;
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionIII sol = new SolutionIII();
		System.out.println(sol.removeDuplicateLetters("cbacdcbc"));
	}

}
