package leet169;

import java.util.HashMap;
import java.util.Map;

public class Solusion {

	public class Node{
		public int val;
		public int num;
		Node next;

		public Node(int value){
			this.val = value;
			this.num = 1;
			this.next = null;
		}
	}

	public Node head = new Node(0);
	public Node tail = head;

	public int majorityElement(int[] num) {

		int i = 0, max = 0, maxVal = num[0];
		Map<Integer, Node> map = new HashMap<Integer, Node>(num.length);
		for(i = 0; i < num.length; i ++){
			if(map.containsKey(num[i]))
				map.get(num[i]).num ++;
			else{
				Node newNode = new Node(num[i]);
				map.put(newNode.val, newNode);
				tail.next = newNode;
				tail = newNode;
			}
		}
		Node t = head.next;
		while(t != null){
			if(t.num > max){
				max = t.num;
				maxVal = t.val;
			}
			t = t.next;
		}

		return maxVal;
	}

	public int majorityElementMoore(int[] num) {
		int candidate = num[0];
		int counter = 0;
		for(int i = 1; i < num.length; i ++){

			if(candidate == num[i])
				counter ++;
			else{
				if(counter == 0)
					candidate = num[i];
				else
					counter --;
			}
			System.out.format("candidate, counter, number: %d, %d, %d\n", candidate, counter, num[i]);
		}
		return candidate;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] t = {3,3,4};
		Solusion obj = new Solusion();
		System.out.println(obj.majorityElementMoore(t));
	}

}