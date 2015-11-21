package amazonOA1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndexFile {

	public static String indexAFile(String s) {
		String[] file = s.split("\\n");
		Map<String, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < file.length; i ++) {
			String[] line = file[i].split("[ ,\\t]+");
			for (String word: line) {
				word = word.toLowerCase();
				if (! map.containsKey(word))
					map.put(word, new ArrayList<Integer>());
				map.get(word).add(i + 1);
			}
		}
		List<String> words = new ArrayList<>(map.keySet());
		Collections.sort(words);
		StringBuilder sb = new StringBuilder();
		for (String word: words) {
			sb.append(word);
			List<Integer> list = map.get(word);
			for (int i = 0; i < list.size(); i ++) {
				char pre = i == 0 ? ' ' : ',';
				sb.append(pre);
				sb.append(list.get(i));
			}
			sb.append('\n');
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "My Name is Simon\nMy favorate Color is Blue\nWhy is the sky blue";
		System.out.println(s);
		String t = IndexFile.indexAFile(s);
		System.out.println(t);
	}

}
	