/**
 * 
 */
package leet075;

public class Solution {

    public void sortColors(int[] A) {
    	int[] counter = new int[3];
    	int i, j, base;
    	for(i = 0; i < A.length; i ++)
    		counter[A[i]] ++;
    	for(i = 0, base = 0; i < 3; i ++){
    		for(j = 0; j < counter[i]; j ++)
    			A[base + j] = i;
    		base += counter[i];
    	}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution obj = new Solution();
		int[] A = {};
		obj.sortColors(A);
		for(int i = 0; i < A.length; i ++)
			System.out.printf("%d, ", A[i]);
	}

}
