package leet127;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

	public List<String> neighbors(String s, Set<String> dict){
		List<String> rslt = new ArrayList<>();
		char[] word = s.toCharArray();
		for(int i = 0; i < word.length; i ++){
			char o = word[i];
			for(char c = 'a'; c <= 'z'; c ++){
				word[i] = c;
				String t = new String(word);
				if(dict.contains(t))
					rslt.add(t);
			}
			word[i] = o;
		}
		return rslt;
	}

	public int calLength(Map<String, List<String>> hashTree, String e){
		List<String> parent = hashTree.get(e);
		int len = 1;
		while(parent != null){
			parent = hashTree.get(parent.get(0));
			len ++;
		}
		return len;
	}
	
	public int ladderLength(String start, String end, Set<String> dict) {
		Set<String> buff = new HashSet<>();
		Map<String, List<String>> hashTree = new HashMap<>();
		hashTree.put(start, null);
		buff.add(start);
		dict.remove(start);
		dict.add(end);
		boolean found = false;
		while(!buff.isEmpty() && !found){
			Set<String> newBuff = new HashSet<>();
			Iterator<String> it = buff.iterator();
			while(it.hasNext()){
				String s = it.next();
				for(String t : neighbors(s, dict)){
					newBuff.add(t);
					if(hashTree.containsKey(t)){
						List<String> parent = hashTree.get(t);
						parent.add(s);
					}
					else{
						List<String> parent = new ArrayList<>();
						parent.add(s);
						hashTree.put(t, parent);
					}
					if(t.compareTo(end) == 0){
						found = true;
						return calLength(hashTree, end);
					}
				}
			}
			dict.removeAll(newBuff);

			buff = newBuff;
		}
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String start = "hit", end = "cog";
		String[] dictionary = {"hot","dot","dog","lot","log"};
		Set<String> dict = new HashSet<>();
		for(int i = 0; i < dictionary.length; i ++)
			dict.add(dictionary[i]);
		Solution obj = new Solution();
		System.out.println(obj.ladderLength(start, end, dict));
	}
}
