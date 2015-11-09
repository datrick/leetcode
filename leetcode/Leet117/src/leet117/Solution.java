package leet117;

public class Solution {

	public void connect(TreeLinkNode root) {
		TreeLinkNode firstNode = root, nextFirstNode = null, t = null;
		while(firstNode != null){
			for(nextFirstNode = null; firstNode != null && nextFirstNode == null; firstNode = firstNode.next){
				if(firstNode.right != null)
					nextFirstNode = firstNode.right;
				if(firstNode.left != null){
					firstNode.left.next = nextFirstNode;
					nextFirstNode = firstNode.left;
				}
			}
			if(nextFirstNode == null)
				return;
			t = nextFirstNode.next == null ? nextFirstNode : nextFirstNode.next;
			
			while(!(firstNode == null)){
				if(firstNode.left != null){
					t.next = firstNode.left;
					t = t.next;
				}
				if(firstNode.right != null){
					t.next = firstNode.right;
					t = t.next;
				}
				firstNode = firstNode.next;
			}
			firstNode = nextFirstNode;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(3);
		root.left.left = new TreeLinkNode(4);
		root.right.left = new TreeLinkNode(5);
		
		Solution obj = new Solution();
		obj.connect(root);
		System.out.println(root.left.left.next.val);
	}

}
