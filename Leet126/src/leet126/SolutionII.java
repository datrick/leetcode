package leet126;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class SolutionII {

	private int calDis(String s, String t){
		int d = 0;
		for(int i = 0; i < s.length(); i ++)
			if(s.charAt(i) != t.charAt(i))
				d ++;
		return d;
	}

	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		List<List<String>> result = new ArrayList<>();
		List<String> tmpList = new LinkedList<>();
		if(calDis(start, end) < 2){
			tmpList.add(start);
			tmpList.add(end);
			result.add(tmpList);
			return result;
		}
		
		List<String> dictList = new ArrayList<>();
		dictList.add(start);
		for(String s : dict)
			if(s.compareTo(start) != 0 && s.compareTo(end) != 0)
				dictList.add(s);
		dictList.add(end);
		int i, j, n = dictList.size();
		boolean s = false, t = false;
		for(i = 1; i <= n - 2; i ++){
			if(calDis(start, dictList.get(i)) == 1)
				s = true;
			if(calDis(end, dictList.get(i)) == 1)
				t = true;
		}
		if(!s || !t)
			return result;
		boolean found = false;
		int[][] adj = new int[n][n];
		int[] status = new int[n];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(0);
		status[0] = 0;
		while(! queue.isEmpty()){
			i = queue.poll();
			for(j = 1; j < n; j ++){
				if(calDis(dictList.get(i), dictList.get(j)) == 1){
					if(j == n - 1){
						adj[j][i] = 1;
						status[j] = status[i] + 1;
						found = true;
					}
					else{
						if(!found){
							if(status[j] == 0){
								queue.offer(j);
								status[j] = status[i] + 1;
							}
							if(status[j] > status[i]){
//								adj[i][j] = 1;
								adj[j][i] = 1;
							}
						}
					}
				}
			}
		}
/*		System.out.printf("built!\n");
		for(i = 0; i < adj.length; i ++){
			for(j = 0; j < adj.length; j ++)
				System.out.format("%d, ", adj[i][j]);
			System.out.printf("\n");
		}
		System.out.println(dictList);

		for(i = 0; i < adj.length; i ++)
			System.out.format("%d, ", status[i]);
		System.out.printf("\n");*/

		if(!found)
			return result;
		Stack<Integer> st = new Stack<>();
		st.push(n - 1);
		tmpList.add(start);
		tmpList.add(end);
		int next = 0;
		while(!st.isEmpty()){
			i = st.peek();
			for(j = next; j < n; j ++){
				if(adj[i][j] == 1 && status[i] > status[j])
					break;
			}
//			System.out.printf("%d finds parent of %d\n", i, j);
			if(j >= n){
				next = st.pop() + 1;
				tmpList.remove(1);
			}
			if(j < n){
				if(j == 0){
					result.add(new ArrayList<String>(tmpList));
					next = st.pop() + 1;
					tmpList.remove(1);
				}
				else{
					tmpList.add(1, dictList.get(j));
					st.push(j);
					next = 0;
				}
			}
		}
		return result;
	}
}
