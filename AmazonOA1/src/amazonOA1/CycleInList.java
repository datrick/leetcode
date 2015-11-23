package amazonOA1;

public class CycleInList {

	public static boolean hasCycle(ListNode head) {
		ListNode terminator = new ListNode(0);
		ListNode cur = head, next = null;
		while (cur != null && cur != terminator) {
			next = cur.next;
			cur.next = terminator;
			cur = next;
		}
		if (cur == null)
			return false;
		return true;
	}
	
	public static ListNode detectCycle(ListNode head) {
		if (head == null)
			return null;
		ListNode ndx1 = head, ndx2 = head;
		do {
			ndx2 = ndx2.next;
			if (ndx2 != null)
				ndx2 = ndx2.next;
			else
				break;
			ndx1 = ndx1.next;
		} while (ndx2 != null && ndx2 != ndx1);
		if (ndx2 != null) {
			ndx1 = head;
			while (ndx1 != ndx2) {
				ndx1 = ndx1.next;
				ndx2 = ndx2.next;
			}
		}
		return ndx2;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
