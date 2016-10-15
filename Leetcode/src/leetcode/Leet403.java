package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Leet403 {

    public boolean canCross(final int[] stones) {
        final Map<Integer, Integer> map = new HashMap<>();
        final List<Set<Integer>> list = new ArrayList<>();
        for (int i = 0; i < stones.length; i++) {
            list.add(new HashSet<Integer>());
        }
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], i);
        }
        list.get(0).add(1);
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            if (max < stones[i]) {
                return false;
            }
            final Set<Integer> set = list.get(i);
            for (final int m : set) {
                if (map.containsKey(stones[i] + m)) {
                    max = Math.max(stones[i] + m, max);
                    if ((stones[i] + m) == stones[stones.length - 1]) {
                        return true;
                    }
                    for (int k = -1; k <= 1; k++) {
                        if ((m + k) > 0) {
                            list.get(map.get(stones[i] + m)).add(m + k);
                        }
                    }
                }
            }
        }
        if (!list.get(list.size() - 1).isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(final String[] args) {
        final int[] stones = { 0, 1, 2, 3, 4, 8, 9, 11 };
        System.out.println(new Leet403().canCross(stones));
    }

}
