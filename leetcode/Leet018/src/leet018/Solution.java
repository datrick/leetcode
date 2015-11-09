package leet018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {

	public List<List<Integer>> fourSum(int[] num, int target) {
		Stack<Integer> st = new Stack<>();
		List<List<Integer>> rslt = new ArrayList<>();
		if (num.length == 0)
			return rslt;
		Arrays.sort(num);
		if (target > num[num.length - 1] * 4)
			return rslt;
		int next = 0, lastPop = -1, sum = 0;
		while (! (st.isEmpty() && next >= num.length)){
			if (st.size() == 1 && sum >= target)
				break;
			if (st.size() == 4){
				if (sum > target){
					if (sum == target){
						rslt.add(new ArrayList<Integer>());
						for (Integer intObj : st)
							rslt.get(rslt.size() - 1).add(num[intObj]);
					}
					sum -= num[st.pop()];
					lastPop = st.pop();
					sum -= num[lastPop];
					next = lastPop + 1;
				} else {
					lastPop = st.pop();
					sum -= num[lastPop];
					next = lastPop + 1;
				}
//				continue;
				}
			if (next >= num.length) {
				lastPop = st.pop();
				sum -= num[lastPop];
				next = lastPop + 1;
//				continue;
			}
			if (lastPop >= 0)
				for ( ; next < num.length && num[next] == num[lastPop]; next ++) ;
			if (next < num.length){
				st.push(next);
				sum += num[next];
				next += 1;
			}
		}
		return rslt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {-491,-468,-450,-415,-414,-374,-357,-333,-305,-292,-274,-272,-271,-258,-241,-240,-227,-217,-196,-184,-161,-120,-116,-110,-110,-98,-92,-47,-27,-10,-8,-7,-4,-1,19,30,53,62,64,65,137,138,145,160,178,179,209,221,243,270,279,283,290,291,305,308,322,345,354,357,365,366,368,371,376,381,381,394,400,406,429,433,445,446,449,470,471,472};
		List<List<Integer>> rslt = new Solution().fourSum(num, 1863);
		for (List<Integer> l : rslt)
			System.out.println(l.toString());
	}

}
