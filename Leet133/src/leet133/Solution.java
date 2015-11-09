package leet133;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node == null)
			return null;
		Map<Integer, UndirectedGraphNode> map = new HashMap<>();
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		UndirectedGraphNode head = new UndirectedGraphNode(node.label);
		map.put(node.label, head);
		queue.offer(node);
		while(!queue.isEmpty()){
			UndirectedGraphNode tmp = queue.poll();
			for(UndirectedGraphNode nei : tmp.neighbors){
				if(!map.containsKey(nei.label)){
					UndirectedGraphNode newNode = new UndirectedGraphNode(nei.label);
					map.put(nei.label, newNode);
					queue.offer(nei);
				}
				map.get(tmp.label).neighbors.add(map.get(nei.label));
			}
		}
		return head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
