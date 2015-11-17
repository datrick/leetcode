package leet305;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

	private static class SetNode {
		public static int number = 0;
		public static SetNode union (SetNode s1, SetNode s2) {
			if (s1 == null)
				return s2;
			if (s2 == null)
				return s1;
			SetNode.number --;
			if (s1.rank > s2.rank) {
				s2.pLink = s1;
				return s1;
			} else {
				s1.pLink = s2;
				if (s1.rank == s2.rank)
					s2.rank ++;
				return s2;
			}
		}
		public static SetNode findSet (SetNode s) {
			SetNode tmp = s;
			while (tmp.pLink != tmp)
				tmp = tmp.pLink;
			while (s != tmp) {
				SetNode n = s.pLink;
				s.pLink = tmp;
				s = n;
			}
			return tmp;
		}
		private int val;
		public int rank;
		public SetNode pLink;
		public SetNode(int v) {
			this.val = v;
			this.rank = 0;
			this.pLink = this;
			SetNode.number ++;
		}
	}
	public List<Integer> numIslands2(int m, int n, int[][] positions) {
		SetNode.number = 0;
		List<Integer> rslt = new ArrayList<>();
		int[][] nei = { {0, -1}, {0, 1}, {-1, 0}, {1, 0} };
		Map<Integer, SetNode> map = new HashMap<>();
		for (int[] pos: positions) {
			int val = pos[0] * n + pos[1];
			if (map.containsKey(val))
				continue;
			SetNode nd = new SetNode(val);
			map.put(val, nd);
			for (int[] delta: nei) {
				int x = pos[0] + delta[0], y = pos[1] + delta[1];
				if (x < 0 || x >= m || y < 0 || y >= n)
					continue;
				int v = x * n + y;
				if (! map.containsKey(v))
					continue;
				SetNode buddy = map.get(v);
				if (SetNode.findSet(nd) != SetNode.findSet(buddy))
					SetNode.union(SetNode.findSet(nd), SetNode.findSet(buddy));
			}
			rslt.add(SetNode.number);
		}
		return rslt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		try (
				FileReader fr = new FileReader("input.txt");
				BufferedReader br = new BufferedReader(fr);) {
			String line;
			while ((line = br.readLine()) != null)
				sb.append(line);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<int[]> input = new ArrayList<>();
		Pattern p = Pattern.compile("\\d+,\\d+");
		Matcher m = p.matcher(sb.toString());
		while (m.find()) {
			String line = m.group();
			int pos = line.indexOf(',');
			int x = Integer.valueOf(line.substring(0, pos));
			int y = Integer.valueOf(line.substring(pos + 1));
			//System.out.format("(%d, %d)%n", x, y);
			input.add(new int[] {x, y});
		}
		int[][] positions = new int[input.size()][2];
		for (int i = 0; i < input.size(); i ++) {
			int[] pos = input.get(i);
			positions[i] = pos;
		}
		List<Integer> rslt = new Solution().numIslands2(3, 3, positions);
		System.out.println(rslt);
	}

}
