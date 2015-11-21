package leet307;

import java.util.ArrayList;
import java.util.List;

public class NumArray {

	private int[] nums;
	List<int[]> sumList;
	private int size_b, num_b;
    public NumArray(int[] nums) {
        this.nums = nums;
        if (nums.length <= 0)
        	return;
        this.size_b = (int) Math.sqrt(nums.length);
        this.num_b = nums.length % size_b == 0 ? nums.length / size_b : nums.length / size_b + 1;
        this.sumList = new ArrayList<>(num_b);
        for (int i = 0; i < num_b; i ++) {
        	int[] sums = new int[size_b];
        	this.sumList.add(sums);
        	sums[0] = this.nums[i * size_b];
        	for (int j = 1; j < size_b && i * size_b + j < this.nums.length; j ++)
        		sums[j] = sums[j - 1] + this.nums[i * size_b + j];
        }
    }

    void update(int i, int val) {
    	int delta = val - this.nums[i];
        this.nums[i] = val;
        int n = i / this.size_b, m = i - n * size_b;
        int[] sums = this.sumList.get(n);
        for (int j = m; j < sums.length; j ++)
        	sums[j] += delta;
    }

    public int sumRange(int i, int j) {
        int ni = i / this.size_b, nj = j / this.size_b;
        if (ni == nj)
        	return this.sumList.get(ni)[j - size_b * nj] - this.sumList.get(ni)[i - size_b * ni] + this.nums[i];
        int sum = this.sumList.get(ni)[size_b - 1] - this.sumList.get(ni)[i - size_b * ni] + this.nums[i];
        for (int k = ni + 1; k < nj; k ++)
        	sum += this.sumList.get(k)[size_b - 1];
        sum += this.sumList.get(nj)[j - size_b * nj];
        return sum;
    }
    
    public static void main(String[] args) {
    	int[] nums = {0, 9, 5, 7, 3};
    	NumArray obj = new NumArray(nums);
    	for (int i = 0; i < nums.length; i ++)
    		for (int j = i; j < nums.length; j ++)
    			System.out.printf("sum of [%d, %d] is %d%n", i, j, obj.sumRange(i, j));
    	obj.update(4, 5);
    	obj.update(1, 7);
    	obj.update(0, 8);
    }
}
























