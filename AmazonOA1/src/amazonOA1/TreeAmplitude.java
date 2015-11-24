package amazonOA1;

public class TreeAmplitude {

	private static int doAmplitude(TreeNode root, int min, int max) {
		if (root == null)
			return max - min;
		min = Math.min(min, root.val);
		max = Math.max(max, root.val);
		return Math.max(doAmplitude(root.left, min, max), doAmplitude(root.right, min, max));
	}
	public static int treeAmplitude(TreeNode root) {
		if (root == null)
			return 0;
		return doAmplitude(root, root.val, root.val);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "5 8 12 # # 2 # # 9 8 2 # # # 4 5 # # #";
		TreeNode root = DecodeTree.decodeTree(s);
		System.out.println(TreeAmplitude.treeAmplitude(root));
	}
}
