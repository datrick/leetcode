package amazonOA1;

public class LongPalinSubstring {

	public String longestPalindromeSubstring(String s) {
		if (s == null)
			return new String("");
		if (s.length() <= 1)
			return s;
		char[] aos = new char[s.length() * 2 + 1];
		aos[0] = ' ';
		for (int i = 0; i < s.length(); i ++) {
			aos[2 * i + 1] = s.charAt(i);
			aos[2 * i + 2] = ' ';
		}
		int[] dp = new int[aos.length];
		int ind_max = 0;
		for (int i = 1, c = 0; i < aos.length; i ++) {
			if (i > c + dp[c]) 
				dp[i] = 0;
			else
				dp[i] = Math.min(dp[c - (i - c)], dp[c] + c - i);
			if (i + dp[i] >= c + dp[c]) {
				c = i;
				int l = 0;
				for (l = dp[i] + 1; i - l >= 0 && i + l < aos.length && aos[i - l] == aos[i + l]; l ++)	;
				dp[i] = l - 1;
			}
			if (dp[ind_max] < dp[i])
				ind_max = i;
		}
//		System.out.println(Arrays.toString(dp));
		int start_max = (ind_max - dp[ind_max]) / 2;
//		System.out.format("%d, %d%n", start_max, start_max + dp[ind_max]);
		return s.substring(start_max, start_max + dp[ind_max]);
	}
	
	private static ListNode generateList(int[] listValues) {
		ListNode head = new ListNode(0), cur = head;
		for (int v: listValues) {
			cur.next = new ListNode(v);
			cur = cur.next;
		}
		return head.next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "abb";
//		System.out.println(new LongPalinSubstring().longestPalindromeSubstring(s));
//		TreeNode a = new TreeNode(1);
//		TreeNode b = new TreeNode(2);
//		a.left = new TreeNode(2);
//		a.left.left = new TreeNode(3);
//		a.left.right = new TreeNode(4);
//		b.left = new TreeNode(3);
//		b.left.left = new TreeNode(4);
//		System.out.println(new CheckSubtree().isSubTree(a, b));
		int[] listValues = {1, 2, 3, 4, 5};
		ListNode head = generateList(listValues);
		ListNode cur = head;
		for (cur = head; cur != null; cur = cur.next)
			System.out.format("[%d]->", cur.val);
		System.out.println("");
		head = new Reverse2ndHalf().reverse2ndHalf(head);
		for (cur = head; cur != null; cur = cur.next)
			System.out.format("[%d]->", cur.val);
		System.out.println("");
//		listValues = new int[] {1};
//		ListNode l1 = generateList(listValues);
//		listValues = new int[] {10};
//		ListNode l2 = generateList(listValues);
//		head = new MergeTwoSortedLists().mergeTwoLists(l1, l2);
//		for (cur = head; cur != null; cur = cur.next)
//			System.out.format("[%d]->", cur.val);
//		System.out.println("");
//		
//		int[] arrival = {1, 2, 3, 4, 5, 6}, run = {3, 2, 1, 3, 2, 1};
//		System.out.println(ShortestJobFirst.shortestJobFirst(arrival, run));
	}

}
