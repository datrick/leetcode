package leet138;

import java.util.HashMap;
import java.util.Map;

public class Solusion {

	public RandomListNode copyRandomList(RandomListNode head) {
		if(head == null)
			return null;
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		RandomListNode newHead = new RandomListNode(head.label);
		newHead.random = null;
		RandomListNode x = head, y = newHead;
		map.put(head, newHead);
		while(x.next != null){
			y.next = new RandomListNode(x.next.label);
			x = x.next;
			y = y.next;
			map.put(x, y);
		}
		y.next = null;
		map.put(null, null);
		for(x = head, y = newHead; x != null; x = x.next, y = y.next)
			y.random = map.get(x.random);
		return newHead;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
