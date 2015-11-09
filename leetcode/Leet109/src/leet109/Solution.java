package leet109;

public class Solution {

	private ListNode headNode = null;
/*	private TreeNode array2BST(int[] num, int start, int end){
		if(end < start)
			return null;
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = array2BST(num, start, mid - 1);
		root.right = array2BST(num, mid + 1, end);
		return root;
	}*/
	
	private TreeNode sortedList2BSTRecur(int start, int end){
		if(start > end)
			return null;
		int mid = (start + end) / 2;
		TreeNode left = this.sortedList2BSTRecur(start, mid - 1);
		TreeNode root = new TreeNode(headNode.val);
		root.left = left;
		headNode = headNode.next;
		root.right = this.sortedList2BSTRecur(mid + 1, end);
		return root;
	}
	public TreeNode sortedListToBST(ListNode head) {
		if(head == null)
			return null;
		int len;
		headNode = head;
		ListNode ln = head;
		for(len = 0; ln != null; len ++, ln = ln.next);
		/*int[] num = new int[len];
		for(i = 0, ln = head; ln != null; i ++, ln = ln.next)
			num[i] = ln.val;
		return this.array2BST(num, 0, len - 1);*/
		return this.sortedList2BSTRecur(0, len - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
