package leet002;

public class Solution {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode sum = new ListNode(0), pre = sum;
		int carry = 0, res = 0;
		while (l1 != null || l2 != null) {
			if (l1 == null){
				l1 = l2;
				l2 = null;
			}
			res = l2 == null ? l1.val + carry : l1.val + l2.val + carry;
			carry = res / 10;
			res %= 10;
			pre.next = new ListNode(res);
			pre = pre.next;
			l1 = l1 != null ? l1.next : l1;
			l2 = l2 != null ? l2.next : l2;
		}
		if (carry > 0)
			pre.next = new ListNode(carry);
		return sum.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "9999", s2 = "999";
		ListNode l1 = new ListNode(0), l2 = new ListNode(0), cur = l1;
		int i;
		for (i = s1.length() - 1, cur = l1; i >= 0; i --, cur = cur.next)
			cur.next = new ListNode((int) s1.charAt(i) - (int) '0');
		for (i = s2.length() - 1, cur = l2; i >= 0; i --, cur = cur.next)
			cur.next = new ListNode((int) s2.charAt(i) - (int) '0');
		for (cur = l1.next; cur != null; cur = cur.next)
			System.out.printf("%d", cur.val);
		System.out.println(" (l1)");
		for (cur = l2.next; cur != null; cur = cur.next)
			System.out.printf("%d", cur.val);
		System.out.println(" (l2)");
		ListNode sum = new Solution().addTwoNumbers(l1.next, l2.next);
		for (cur = sum; cur != null; cur = cur.next)
			System.out.printf("%d", cur.val);
		System.out.println(" (sum)");
	}

}
