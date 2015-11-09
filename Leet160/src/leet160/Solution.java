package leet160;

public class Solution {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lenA = 0, lenB = 0;
		ListNode tmp = null, lnA = headA, lnB = headB;
		for (tmp = headA; tmp != null; tmp = tmp.next)
			lenA ++;
		for (tmp = headB; tmp != null; tmp = tmp.next)
			lenB ++;
		int err = 0;
		if (lenA > lenB) {
			err = lenA - lenB;
			for (int i = 0; i < err; i ++)
				lnA = lnA.next;
		} else {
			err = lenB - lenA;
			for (int i = 0; i < err; i ++)
				lnB = lnB.next;
		}
		while (lnA != null && lnB != null && lnA != lnB) {
			lnA = lnA.next;
			lnB = lnB.next;
		}
		return lnA;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
