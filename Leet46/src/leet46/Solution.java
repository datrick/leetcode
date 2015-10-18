package leet46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	
	public void calPermute(List<Integer> pool, List<Integer> sb, List<List<Integer>> result)
	{
		if(pool.size() == 1){
			sb.add(pool.get(0));
			result.add(new ArrayList<Integer>(sb));
			sb.remove(sb.size() - 1);
			return;
		}
		for(int i = 0; i < pool.size(); i ++){
			sb.add(pool.remove(i));
			calPermute(pool, sb, result);
			pool.add(i, sb.remove(sb.size() - 1));
		}
	}
	
	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> pool = new LinkedList<Integer>();
		List<Integer> sb = new ArrayList<>();
		for(int i = 0; i < num.length; i ++)
			pool.add(i, num[i]);
		this.calPermute(pool, sb, result);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1};
		Solution obj = new Solution();
		System.out.println(obj.permute(num));
	}

}
