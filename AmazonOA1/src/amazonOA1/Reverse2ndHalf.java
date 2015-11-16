package amazonOA1;

public class Reverse2ndHalf {

	public ListNode reverse2ndHalf(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode fast = head, slow = head;
		while (fast.next != null && fast.next.next != null && fast.next.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode pre = null, cur = slow.next, next = null;
		while (cur != null) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		slow.next = pre;
		return head;
	}
}
