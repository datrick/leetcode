package leet126;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	private int calDis(String s, String t){
		int d = 0;
/*		System.out.format("s: %s, t: %s\n", s, t);
*/		for(int i = 0; i < s.length(); i ++){
/*			System.out.format("s: %c, t: %c\n", s.charAt(i), t.charAt(i));
*/			if(Character.compare(s.charAt(i), t.charAt(i)) != 0)
				d ++;
		}
		return d;
	}

	private void addStep(int i, int len, String end, List<List<String>> step, List<String> tmpList, List<List<String>> result){
		String t = tmpList.get(i - 1);
		if(i == len){
			/*			if(calDis(t, end) == 1){*/
			tmpList.add(end);
			result.add(new ArrayList<String>(tmpList));
			tmpList.remove(len);
			/*			}*/
			return;
		}
		for(String s : step.get(i)){
			if(calDis(s, t) == 1){
				tmpList.add(s);
				addStep(i + 1, len, end, step, tmpList, result);
				tmpList.remove(i);
			}
		}
	}

	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		List<List<String>> result = new ArrayList<>();
		List<String> tmpList = new ArrayList<>();
		tmpList.add(start);
		int len = this.calDis(start, end), t, k;
		System.out.println(len);
		if(len < 2){
			tmpList.add(end);
			result.add(new ArrayList<String>(tmpList));
			return result;
		}
		List<List<String>> step = new ArrayList<>();
		for(int i = 0; i < len; i ++)
			step.add(new ArrayList<String>());
		for(String s : dict){
			t = this.calDis(start, s);
			k = this.calDis(s, end);
			System.out.format("%s: start: %d, end: %d\n", s, t, k);
			if(t + k == len)
				step.get(t).add(s);
		}
		for(int i = 0; i < len; i ++)
			if(step.get(i).isEmpty())
				return null;
		this.addStep(1, len, end, step, tmpList, result);
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String start = "cet", end = "ism";
		String[] dictionary = {"kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"};
		Set<String> dict = new HashSet<>();
		for(int i = 0; i < dictionary.length; i ++)
			dict.add(dictionary[i]);
		SolutionIII obj = new SolutionIII();
		List<List<String>> result = obj.findLadders(start, end, dict);
		System.out.println(result);
	}

}
