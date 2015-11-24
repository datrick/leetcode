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
		//insert the node before cur
		head.pre = cur.pre;
		head.next = cur;
		head.pre.next = head;
		cur.pre = head;
		return node;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2, 4, 4, 4, 6, 8 };
		CircularLinkedList node = null, cur = null;
		for (int v: nums) {
			cur = new CircularLinkedList(v);
			if (node == null) {
				node = cur;
				node.next = node;
				node.pre = node;
			} else {
				cur.next = node.next;
				cur.pre = node;
				cur.next.pre = cur;
				node.next = cur;
				node = cur;
			}
		}
		for (int v: nums)
			node = InsertCLL.insertCircularLinkedList(node.next.next.next, v);
		cur = node;
		do {
			System.out.format("%d ", cur.val);
			cur = cur.next;
		} while (cur != node);
	}

}
