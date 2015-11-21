package phoneInterview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathSum {

	private void insertToMap(int val, Map<Integer, List<List<Integer>>> map_c, Map<Integer, List<List<Integer>>> map) {
		for (Map.Entry<Integer, List<List<Integer>>> entry: map_c.entrySet()) {
			int v = val + entry.getKey();
			for (List<Integer> list: entry.getValue()) {
				list.add(0, val);
			}
			if (map.containsKey(v))
				map.get(v).addAll(entry.getValue());
			else
				map.put(v, entry.getValue());
		}
			
	}
	private Map<Integer, List<List<Integer>>> doPathSum(TreeNode root, int target, List<List<Integer>> rslt) {
		Map<Integer, List<List<Integer>>> map = new HashMap<>(), map_l = null, map_r = null;
		List<List<Integer>> list = new ArrayList<>();
		list.add(new ArrayList<>());
		map.put(0, list);
		if (root == null)
			return map;
		map_l = this.doPathSum(root.left, target, rslt);
		map_r = this.doPathSum(root.right, target, rslt);
		for (int v: map_l.keySet()) {
			int t = target - v - root.val;
			if (map_r.containsKey(t)) {
				for (List<Integer> list_l: map_l.get(v))
					for (List<Integer> list_r: map_r.get(t)) {
						List<Integer> res = new ArrayList<>(list_r);
						res.add(0, root.val);
						List<Integer> tmp = new ArrayList<>(list_l);
						Collections.reverse(tmp);
						tmp.addAll(res);
						rslt.add(tmp);
					}
			}
		}
		insertToMap(root.val, map_l, map);
		List<List<Integer>> list_0 = map_r.get(0);
		map_r.remove(0);
		for (int i = 0; i < list_0.size(); i ++)
			if (list_0.get(i).isEmpty())
				list_0.remove(i);
		map_r.put(0, list_0);
		insertToMap(root.val, map_r, map);
		return map;
	}
	
	public List<List<Integer>> pathSum(TreeNode root, int target) {
		List<List<Integer>> rslt = new ArrayList<>();
		this.doPathSum(root, target, rslt);
		return rslt;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		List<List<Integer>> rslt = new PathSum().pathSum(root, 8);
		for (List<Integer> list: rslt)
			System.out.println(list.toString());
	}

}
