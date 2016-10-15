package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leet402 {
    public String removeKdigits(final String num, final int k) {
        if ((num == null) || (num.length() < k) || (k <= 0)) {
            return num;
        }
        if (num.length() == k) {
            return "0";
        }
        final List<Integer> list = new ArrayList<>();
        char m = '9', c;
        for (int i = 0; i <= k; i++) {
            c = num.charAt(i);
            if (c == m) {
                list.add(i);
            } else if (c < m) {
                list.clear();
                m = c;
                list.add(i);
            }
        }
        String min = null;
        for (final int j : list) {
            String s = "";
            if ((num.length() - 1) > k) {
                s = removeKdigits(num.substring(j + 1), k - j);
            }
            min = min == null ? s : (s.compareTo(min) < 0 ? s : min);
        }
        if ((m == '0') && (min.compareTo("") != 0)) {
            return min;
        } else {
            return Character.toString(m) + min;
        }
    }

    public static void main(final String[] args) {
        final String num = "1432219";
        final int k = 3;
        System.out.println(new Leet402().removeKdigits(num, k));
    }

}
