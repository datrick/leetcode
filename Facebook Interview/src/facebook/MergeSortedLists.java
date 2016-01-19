package facebook;

import java.util.Deque;
import java.util.LinkedList;

public class MergeSortedLists {

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length <= 0)
			return null;
		ListNode head = new ListNode(0), cur = head, h1 = null, h2 = null;
		Deque<ListNode> queue = new LinkedList<>();
		for (ListNode node: lists)
			queue.offer(node);
		while (queue.size() > 1) {
			h1 = queue.poll();
			h2 = queue.poll();
			cur = head;
			while (h1 != null && h2 != null) {
				if (h1.val <= h2.val) {
					cur.next = h1;
					h1 = h1.next;
				} else {
					cur.next = h2;
					h2 = h2.next;
				}
				cur = cur.next;
				cur.next = null;
			}
			cur.next = h1 == null ? h2 : h1;
			queue.offer(head.next);
			head.next = null;
		}
		return queue.poll();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
