package leet141;

public class Solution {

	public boolean hasCycle(ListNode head) {
		ListNode terminal = new ListNode(-1);
		if(head == null)
			return false;
		ListNode t = head, tmp = head;
		while(t.next != null && t.next != terminal){
			tmp = t.next;
			t.next = terminal;
			t = tmp;
		}
		if(t.next == terminal)
			return true;
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
