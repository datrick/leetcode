package leet030;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionII extends Solution{

	public List<Integer> findSubstring(String S, List<String> L){
		Map<String, Integer> counter, oriCounter = new HashMap<>();
		List<Integer> rslt = new ArrayList<>();
		int wordLen = L.get(0).length(), stringLen = S.length(), wordsNum = L.size();
		int count = 0, i = 0, j = 0;
		for (i = 0; i < wordsNum; i ++){
			String s = L.get(i);
			Integer intObj = oriCounter.get(s);
			if (intObj == null)
				oriCounter.put(s, 1);
			else
				oriCounter.put(s, intObj + 1);
		}
		
		for (i = 0; i < wordLen; i ++){
			counter = new HashMap<>(oriCounter);
			count = 0;
			for (j = i; j <= stringLen - wordLen; j += wordLen){
				String s = S.substring(j, j + wordLen);
				Integer intObj = counter.get(s);
				if (intObj == null){
					for (int k = j - count * wordLen; k < j; k += wordLen){
						String t = S.substring(k, k + wordLen);
						Integer obj = counter.get(t);
						counter.put(t, obj + 1);
						count -= 1;
					}
				}
				else {
					counter.put(s, intObj - 1);
					if (intObj == 0){
						for (int k = j - count * wordLen; k < j; k += wordLen){
							String t = S.substring(k, k + wordLen);
							Integer obj = counter.get(t);
							counter.put(t, obj + 1);
							count -= 1;
							if (obj < 0)
								break;
						}
					}
					count += 1;
					if (count == wordsNum)
						rslt.add(j - (wordsNum - 1) * wordLen);
				}
			}
		}
		return rslt;
	}
}
