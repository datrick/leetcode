package leet088;

public class Solution {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i, j;
		for (i = m + n - 1, j = m - 1; j >= 0; j --, i --)
			nums1[i] = nums1[j];
		i += 1;
		j = 0;
		int k = 0;
		while (i < m + n && j < n) {
			if (nums1[i] <= nums2[j])
				nums1[k ++] = nums1[i ++];
			else
				nums1[k ++] = nums2[j ++];
		}
		if (i >= m + n) {
			while (j < n)
				nums1[k ++] = nums2[j ++];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1, 3, 5, 7, 9, 0, 0, 0, 0, 0, 0, 0},
				nums2 = {2, 4, 6, 8, 10};
		new Solution().merge(nums1, 3, nums2, 5);
		for (int i = 0; i < 8; i ++)
			System.out.print(nums1[i] + " ");
	}

}
