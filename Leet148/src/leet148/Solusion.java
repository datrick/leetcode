package leet148;

public class Solusion {

	//chose the first node as the middle, sort from middle.next to node before tail
	private ListNode divide(ListNode head, ListNode tail){
		ListNode mid = head, t = head.next, x = mid;
		int tem;
		while(t != tail){
			if(t.val <= mid.val){
				tem = x.next.val;
				x.next.val = t.val;
				t.val = tem;
				x = x.next;
			}
			t = t.next;
		}
		tem = mid.val;
		mid.val = x.val;
		x.val = tem;
		return x;
	}
	
	private void sortRec(ListNode head, ListNode tail){
		ListNode mid = this.divide(head, tail);
		if(mid != head)
			sortRec(head, mid);
		if(mid.next != tail)
			sortRec(mid.next, tail);
	}
	
	public ListNode sortList(ListNode head) {
		if(head == null)
			return null;
		this.sortRec(head, null);
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solusion obj = new Solusion();
		ListNode head = new ListNode(Integer.MAX_VALUE), tail = head;
		int[] num = {5, 4, 3, 2, 1};
		for(int i = 0; i < num.length; i ++){
			tail.next = new ListNode(num[i]);
			tail = tail.next;
		}
		tail = obj.sortList(head.next);
//		tail = head.next;
		while(tail != null){
			System.out.format("%d, ", tail.val);
			tail = tail.next;
		}
	}

}
