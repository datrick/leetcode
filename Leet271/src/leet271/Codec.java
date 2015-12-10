package leet271;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Codec {

	public static void main(String[] args) {
		Codec codec = new Codec();
		List<String> strs = new ArrayList<>(Arrays.asList("abc", "de", "fgc"));
		String s = codec.encode(strs);
		List<String> rslt = codec.decode(s);
		System.out.println(rslt);
	}
	// Encodes a list of strings to a single string.
	public String encode(List<String> strs) {
		if (strs == null || strs.size() <= 0)
			return "";
		StringBuilder sb = new StringBuilder(), sbs = new StringBuilder();
		for (String s: strs) {
			if (sb.length() != 0)
				sb.append(",");
			sb.append(s.length());
			sbs.append(s);
		}
		sb.append("$");
		sb.append(sbs);
		return sb.toString();
	}

	// Decodes a single string to a list of strings.
	public List<String> decode(String s) {
		List<String> rslt = new ArrayList<>();
		if (s == null || s.length() <= 0)
			return rslt;
		int begin = s.indexOf('$');
		String[] idx = s.substring(0, begin).split(",");
		begin ++;
		for (int i = 0; i < idx.length; i ++) {
			int end = begin + Integer.valueOf(idx[i]);
			rslt.add(s.substring(begin, end));
			begin = end;
		}
		return rslt;
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
