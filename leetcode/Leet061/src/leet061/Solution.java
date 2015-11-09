package leet061;

public class Solution {
	
	//Definition for singly-linked list.
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

    public ListNode rotateRight(ListNode head, int k) {
    	if (head == null || k == 0)
    		return head;
    	ListNode runner = head, follower = null;
    	int num = 1;
    	for (; runner.next != null; runner = runner.next, num ++){
    		if (num == k)
    			follower = head;
    		else if (num > k)
    			follower = follower.next;
    	}
    	if (k == num)
    		return head;
    	if (k > num)
    		return this.rotateRight(head, k % num);
    	if (k < num){
    		runner.next = head;
    		head = follower.next;
    		follower.next = null;
    	}
    	return head;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
