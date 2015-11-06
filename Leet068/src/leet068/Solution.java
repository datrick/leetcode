package leet068;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public List<String> fullJustify(String[] words, int L) {
		List<String> justifiedText = new ArrayList<>();
		int i = 0, j, k, num, sum;
		while(i < words.length){
			for(j = i, num = 0, sum = 0; j < words.length; j ++){
				if (sum + num + words[j].length() <= L){
					num ++;
					sum += words[j].length();
				} else 
					break;
			}
			if (j >= words.length){
				StringBuilder sb = new StringBuilder();
				for(k = i; k < words.length; k ++){
					if(k - i > 0)
						sb.append(" ");
					sb.append(words[k]);
				}
				for(int m = sb.length(); m < L; m ++)
						sb.append(" ");
				justifiedText.add(sb.toString());
			} else {
				if (num == 1){
					StringBuilder sb = new StringBuilder();
					sb.append(words[i]);
					for(int m = sb.length(); m < L; m ++)
						sb.append(" ");
					justifiedText.add(sb.toString());
				} else {
					int l = (L - sum) / (num - 1);
					int y = L - sum - l * (num - 1);
					StringBuilder sb = new StringBuilder();
					for(int m = 0; m < num; m ++){
						sb.append(words[i + m]);
						if (m < y)
							for(int n = 0; n < l + 1; n ++)
								sb.append(" ");
						if (m >= y && m < num - 1)
							for(int n = 0; n < l; n ++)
								sb.append(" ");
					}
					justifiedText.add(sb.toString());
				}
			}
			i = j;
		}
		return justifiedText;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution obj = new Solution();
		String[] words = {"Listen","to","many,","speak","to","a","few."};
		System.out.println(words.length);
		System.out.println(obj.fullJustify(words, 6));
	}

}
