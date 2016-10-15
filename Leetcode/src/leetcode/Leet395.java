package leetcode;

public class Leet395 {

    public int longestSubstring(final String s, final int k) {
        if ((s == null) || (s.length() < k)) {
            return 0;
        }
        final int[] dict = new int[26];
        for (int i = 0; i < s.length(); i++) {
            dict[s.charAt(i) - 'a']++;
        }
        boolean flag = true;
        for (final int i : dict) {
            if ((i > 0) && (i < k)) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return s.length();
        }
        int p = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (dict[s.charAt(i) - 'a'] < k) {
                max = Math.max(max, longestSubstring(s.substring(p, i), k));
                p = i + 1;
            }
        }
        if (p < s.length()) {
            max = Math.max(max, longestSubstring(s.substring(p), k));
        }
        return max;
    }

    public static void main(final String[] args) {
        final String s = "aaabbcbacac";
        final int k = 3;
        System.out.println(new Leet395().longestSubstring(s, k));
    }
}
