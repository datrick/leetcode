package leet025;

public class Solution {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		if (k == 0 || head == null)
			return head;
		ListNode dummyHead = new ListNode(0), lastTail = dummyHead, cur = head, pre = null, next = null;
		int i = 0;
		while (cur != null){
			ListNode newTail = cur;
			for (i = 0, pre = null; i < k && cur != null; i ++){
				next = cur.next;
				cur.next = pre;
				pre = cur;
				cur = next;
			}
			if (i < k ){
				cur = pre;
				pre = next;
				while (cur != null){
					next = cur.next;
					cur.next = pre;
					pre = cur;
					cur = next;
				}
			}
			lastTail.next = pre;
			lastTail = newTail;
		}
		return dummyHead.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] listValues = { 1, 2, 3, 4, 5};
		Solution.ListNode head = new Solution.ListNode(0), cur = head;
		for (int i : listValues){
			cur.next = new Solution.ListNode(i);
			cur = cur.next;
		}
		head = new Solution().reverseKGroup(head.next, 0);
		for (cur = head; cur != null; cur = cur.next)
			System.out.format("%d ", cur.val);
	}

}
