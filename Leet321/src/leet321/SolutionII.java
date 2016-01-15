package leet321;

import java.util.Arrays;


public class SolutionII {

	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		int[] res = new int[k];
		if (nums1 == null || nums2 == null || k == 0)
			return res;
		boolean[][] greater = new boolean[nums1.length + 1][nums2.length + 1];
		for (int i = 0; i <= nums1.length; i ++)
			greater[i][nums2.length] = true;
		for (int i = nums1.length - 1; i >= 0; i --)
			for (int j = nums2.length - 1; j >= 0; j --) {
				if (nums1[i] == nums2[j])
					greater[i][j] = greater[i + 1][j + 1];
				else 
					greater[i][j] = nums1[i] > nums2[j];
			}
		for (int i = 0, j = 0, l = 0; l < k; l ++) {
			int idx1 = i, idx2 = j, n = k - l;
			for (int p = i; p < nums1.length && nums1.length - p + nums2.length - j >= n; p ++)
				idx1 = nums1[p] > nums1[idx1] ? p : idx1;
			for (int p = j; p < nums2.length && nums1.length - i + nums2.length - p >= n; p ++)
				idx2 = nums2[p] > nums2[idx2] ? p : idx2;
			if (greater[idx1][idx2]) {
				res[l] = nums1[idx1];
				i = idx1 + 1;
			} else {
				res[l] = nums2[idx2];
				j = idx2 + 1;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {8, 9}, nums2 = {3, 9};
		System.out.println(Arrays.toString(new SolutionII().maxNumber(nums1, nums2, 3)));
	}

}
