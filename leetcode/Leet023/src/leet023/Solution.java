package leet023;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	private void shiftDown(List<ListNode> bHeap, int i) {
		while (2 * i + 1 < bHeap.size()){
			ListNode tmp = bHeap.get(i);
			int left = bHeap.get(2 * i + 1).val;
			int right = 2 * i + 2 < bHeap.size() ? bHeap.get(2 * i + 2).val : Integer.MAX_VALUE;
			if (tmp.val <= left && tmp.val <= right)
				break;
			int index = left <= right ? 2 * i + 1 : 2 * i + 2;
			bHeap.set(i, bHeap.get(index));
			bHeap.set(index, tmp);
			i = index;
		}
	}
	
	public ListNode mergeKLists(List<ListNode> lists) {
		ListNode head = new ListNode(0), curTail = head;
		for (int i = 0; i < lists.size(); i ++)
			while (i < lists.size() && lists.get(i) == null)
				lists.remove(i);
		for (int i = lists.size() / 2 - 1; i >= 0; i --)
			this.shiftDown(lists, i);
		
		while (! lists.isEmpty()) {
			if (lists.size() == 1){
				curTail.next = lists.get(0);
				lists.remove(0);
				continue;
			}
			curTail.next = lists.get(0);
			lists.set(0, curTail.next.next);
			curTail = curTail.next;
			curTail.next = null;
			if (lists.get(0) == null){
				lists.set(0, lists.get(lists.size() - 1));
				lists.remove(lists.size() - 1);
			}
			this.shiftDown(lists, 0);
		}
		return head.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<ListNode> lists = new ArrayList<>();
		int[][] A = { {1, 3, 5, 7, 9}, {1, 3, 5, 7, 9}, {2, 4, 6} };
		for (int i = 0; i < A.length; i ++){
			lists.add(new ListNode(A[i][0]));
			ListNode cur = lists.get(i);
			for (int j = 1; j < A[i].length; j ++){
				cur.next = new ListNode(A[i][j]);
				cur = cur.next;
			}
		}
		for (ListNode node : lists){
			ListNode cur = node;
			while (cur != null){
				System.out.format("%d ",cur.val);
				cur = cur.next;
			}
			System.out.println("");
		}
		ListNode head = new Solution().mergeKLists(lists);
		ListNode cur = head;
		while (cur != null){
			System.out.format("%d ", cur.val);
			cur = cur.next;
		}
	}

}
