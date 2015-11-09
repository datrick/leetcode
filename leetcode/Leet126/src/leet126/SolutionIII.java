package leet126;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class SolutionIII {

	public List<TreeNode> findNei(TreeNode p, Set<String> dict){
		List<TreeNode> neighbors = new ArrayList<>();
		char[] word = p.val.toCharArray();
		for(int i = 0; i < word.length; i ++){
			char o = word[i], c = 'a';
			for(c = 'a'; c <= 'z'; c ++){
				if(c != o){
					word[i] = c;
					String s = new String(word);
//					System.out.printf("new word is: %s\n", s);
					if(dict.contains(s)){
						TreeNode newNode = new TreeNode(s, p);
						neighbors.add(newNode);
					}
				}
			}
			word[i] = o;
		}
		return neighbors;
	}

	public void addResult(TreeNode node, List<List<String>> result){
		List<String> tmpList = new LinkedList<String>();
		while(node != null){
			tmpList.add(0, node.val);
			node = node.parent;
		}
//		System.out.format("here is a result:");
//		System.out.println(tmpList);
		result.add(tmpList);
	}

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
		TreeNode root = new TreeNode(start, null);
		root.sibling = null;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		dict.remove(root.val);
//		System.out.println(root.val);
		boolean found = false;
		while(!queue.isEmpty() && !found){
			TreeNode pre = null;
			TreeNode node = queue.poll();
//			System.out.printf("%s is polled out\n", node.val);
			List<TreeNode> children = new ArrayList<>();
			while(node != null){
				if(calDis(node.val, end) == 1){
					TreeNode endNode = new TreeNode(end, node);
					node.neighbors.add(endNode);
					addResult(endNode, result);
					found = true;
				}
				else
					children.addAll(findNei(node, dict));
				node = node.sibling;
			}
			pre = null;
			if(!children.isEmpty()){
				pre = children.get(0);
				queue.offer(pre);
				for(int i = 1; i < children.size(); i ++){
					pre.sibling = children.get(i);
					pre = children.get(i);
				}
			}
			if(pre != null)
				pre.sibling = null;
			for(TreeNode t : children)
				if(dict.contains(t.val))
					dict.remove(t.val);
//			if(level <= 3){
//				System.out.printf("the words in level %d is: \n", level ++);
//				for(TreeNode t : children)
//					System.out.format("%s, ", t.val);
//				System.out.printf("\n");
//			}
			children.clear();
		}
		return result;
	}
}
