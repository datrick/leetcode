package leet126;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

	public String val;
	List<TreeNode> neighbors;
	TreeNode sibling, parent;
	public TreeNode(String s, TreeNode p){
		val = s;
		parent = p;
		neighbors = new ArrayList<TreeNode>();
		sibling = null;
	}
}
