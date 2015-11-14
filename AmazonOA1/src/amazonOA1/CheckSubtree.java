package amazonOA1;

public class CheckSubtree {

	private String serializeBST(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		if (root == null)
			return sb.toString();
		sb.append(root.val);
		sb.append("(" + serializeBST(root.left) + ")");
		sb.append("(" + serializeBST(root.right) + ")");
		return sb.toString();
	}
	public boolean isSubTree(TreeNode a, TreeNode b) {
		String soa = this.serializeBST(a), sob = this.serializeBST(b);
		return soa.contains(sob);
	}
}
