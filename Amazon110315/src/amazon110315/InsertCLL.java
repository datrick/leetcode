package amazon110315;

public class InsertCLL {

	public static CircularLinkedList insertCircularLinkedList(CircularLinkedList node, int x){ 
		CircularLinkedList head = new CircularLinkedList(x);
		head.next = head;
		head.pre = head;
		if (node == null) 
			return head;
		CircularLinkedList cur = node;
		if (x > node.val) {
			cur = node.next;
			while (cur != node) {
				if (x <= cur.val || cur.val < cur.pre.val)
					break;
				cur = cur.next;
			}
		}
		if (x < node.val) {
			cur = node.pre;
			while (cur != node) {
				if (x >= cur.val || cur.val > cur.next.val)
					break;
				cur = cur.pre;
			}
			cur = cur.next;
		}
		head.pre = cur.pre;
		cur.pre.next = head;
		head.next = cur;
		cur.pre = head;
		return node;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
