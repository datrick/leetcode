package leet033;

public class Solution {

	public int search(int[] A, int target) {
		int start = 0, end = A.length - 1;
		while (start <= end){
			int mid = (start + end) / 2;
			if (A[mid] == target)
				return mid;
			if ( target >= A[start] && target < A[mid] || target < A[mid] && A[mid] < A[start] || A[mid] < A[start] && target > A[mid] && target > A[end])
				end = mid - 1;
			else
				start = mid + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {4, 5, 6, 7, 0, 1, 2};
		int[] target = {-1, 4, 5, 6, 7, 0, 1, 2, 3, 8};
		for (int i = 0; i < target.length; i ++)
			System.out.println(new Solution().search(A, target[i]));
		
	}

}
