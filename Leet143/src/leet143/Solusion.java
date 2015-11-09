package leet143;

public class Solusion {

	public void reorderList(ListNode head) {
		int num = 0;
		ListNode t = head, w = null;
		for(;t != null; num++, t = t.next);
		if(num <= 2)
			return;
		int mid = (num - 1) / 2;
		for(num = 0, t = head; num < mid; num ++, t = t.next);
		ListNode newHead = t.next;
		t.next = null;
/*		for(t = head; t != null; t = t.next)
			System.out.printf("%d, ", t.val);
		System.out.printf("\n");
		for(t = newHead; t != null; t = t.next)
			System.out.printf("%d, ", t.val);
		System.out.printf("\n");*/
		w = newHead.next;
		newHead.next = null;
		while(w != null){
			t = w.next;
			w.next = newHead;
			newHead = w;
			w = t;
		}
/*		for(t = newHead; t != null; t = t.next)
			System.out.printf("%d, ", t.val);
		System.out.printf("\n");*/
		for(t = head;newHead != null && t != null;){
			w = newHead;
			newHead = newHead.next;
			w.next = t.next;
			t.next = w;
			t = w.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1, 2, 3, 4, 5};
		ListNode head = new ListNode(num[0]);
		ListNode t = head;
		for(int i = 1; i < num.length; i ++){
			t.next = new ListNode(num[i]);
			t = t.next;
		}
		t.next = null;
		for(t = head; t != null; t = t.next)
			System.out.printf("%d, ", t.val);
		System.out.printf("\n");
		Solusion obj = new Solusion();
		obj.reorderList(head);
		for(t = head; t != null; t = t.next)
			System.out.printf("%d, ", t.val);
		System.out.printf("\n");
	}

}
