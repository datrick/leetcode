package facebook;

import java.util.ArrayList;
import java.util.List;

public class CommonAncestor {

	Object[] depthAndNode(TreeNode root) {
		if (root == null)
			return null;
		Object[] res = new Object[2];
		if (root.children.size() <= 0) {
			res[0] = new Integer(0);
			res[1] = null;
		}
		List<Integer> depth = new ArrayList<>();
		List<TreeNode> nodes = new ArrayList<>();
		int max = 0, nMax = 0;
		TreeNode resNode = null;
		for (TreeNode node: root.children) {
			res = depthAndNode(node);
			depth.add((Integer) res[0]);
			nodes.add((TreeNode) res[1]);
			if ((Integer) res[0] > max) {
				max = (Integer) res[0];
				nMax = 1;
				resNode = (TreeNode) res[1];
			} else {
				if ((Integer) res[0] == max)
					nMax ++;
			}
		}
		res[0] = max + 1;
		res[1] = (nMax == 1) ? resNode : root;
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
