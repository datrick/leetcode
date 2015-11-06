package lrucache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	public class Node{
		Integer value;
		Integer key;
		Node next;
		Node prev;
		public Node(int k, int v){
			this.key = k;
			this.value = v;
			this.prev = null;
			this.next = null;
		}
	}

	private Map<Integer, Node> lruCache;
	private Node head = new Node(0,0);
	int cap;

	public LRUCache(int capacity) {
		lruCache = new HashMap<Integer, Node>(capacity);
		head.next = head;
		head.prev = head;
		cap = capacity;
	}

	private void move2Head(Node head, Node t){
		if(t.prev != null && t.next != null){
			t.prev.next = t.next;
			t.next.prev = t.prev;
		}
		t.next = head.next;
		t.prev = head;
		head.next = t;
		t.next.prev = t;
	}

	public int get(int key) {
		Node t = lruCache.get(key);
		if(t == null)
			return -1;
		if(t != head.next)
			this.move2Head(head, t);
		return (t.value);
	}

	public void set(int key, int value) {
//		if the key is already in the HashMap, remove the current node from the linked list and the map
		if(this.lruCache.containsKey(key)){
			Node temp = this.lruCache.get(key);
			temp.prev.next = temp.next;
			temp.next.prev = temp.prev;
			this.lruCache.remove(temp.key, temp);
		}
//		if the map is full, remove the last one from the linked list, as well as from the map
		if(lruCache.size() == this.cap){
			Node temp = this.head.prev;
			this.head.prev = temp.prev;
			temp.prev.next = head;
			lruCache.remove(temp.key, temp);
		}
//		add a new node in the map, and insert it as the head of the linked list
		Node newHead = new Node(key, value);
		lruCache.put(key, newHead);
		this.move2Head(this.head, newHead);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cap = 2;
		LRUCache cache = new LRUCache(cap);
		/*for(i = 1; i <= 10; i ++){
			cache.set(i*15+2, i*15);
		}
		for(i = 1; i <= 10; i ++)
			System.out.printf("%d, ", cache.get(i*15+1));*/
		cache.set(2, 1);
		cache.set(2, 2);
		System.out.printf("%d\n", cache.get(2));
		cache.set(1, 1);
		cache.set(4, 1);
		System.out.printf("%d\n", cache.get(2));
		Node temp = cache.head.next;
		while(temp != cache.head){
			System.out.format("%d, ", temp.value);
			temp = temp.next;
		}

	}

}
