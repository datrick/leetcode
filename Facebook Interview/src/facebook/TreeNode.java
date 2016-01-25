package facebook;

import java.util.LinkedList;
import java.util.List;

public class TreeNode {
	int value;
	List<TreeNode> children;
	public TreeNode(int val) {
		this.value = val;
		this.children = new LinkedList<>();
	}
}
