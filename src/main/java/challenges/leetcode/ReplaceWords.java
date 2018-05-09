package challenges.leetcode;

import java.util.Arrays;
import java.util.List;

/**
* @date	Apr 25, 2018 9:20:24 AM
* @author Darpan Shah
*/
/*
Problem:
=======
*/
public class ReplaceWords {
	Trie root = new Trie();
    public void insertRoots(List<String> dict){
        for(String rt: dict){
            root.insert(rt);
        }
    }
    public String replaceWords(List<String> dict, String sentence) {
        insertRoots(dict);
        String[] succ = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String sc: succ){
        	System.out.println(sc);
            String replace = root.findShortestRoot(sc);
            if(replace!=null){
                sb.append(replace);
            }else{
                sb.append(sc);
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }
    public static void main(String[] args) {
		List<String> list = Arrays.asList("e","k","c","harqp","h","gsafc","vn","lqp","soy","mr","x","iitgm","sb","oo","spj","gwmly","iu","z","f","ha","vds","v","vpx","fir","t","xo","apifm","tlznm","kkv","nxyud","j","qp","omn","zoxp","mutu","i","nxth","dwuer","sadl","pv","w","mding","mubem","xsmwc","vl","farov","twfmq","ljhmr","q","bbzs","kd","kwc","a","buq","sm","yi","nypa","xwz","si","amqx","iy","eb",
				"qvgt","twy","rf","dc","utt","mxjfu","hm","trz","lzh","lref","qbx","fmemr","gil","go","qggh","uud","trnhf","gels","dfdq","qzkx","qxw");
		String sent = "ikkbp miszkays wqjferqoxjwvbieyk gvcfldkiavww vhokchxz dvypwyb bxahfzcfanteibiltins ueebf lqhflvwxksi dco kddxmckhvqifbuzkhstp wc ytzzlm gximjuhzfdjuamhsu gdkbmhpnvy ifvifheoxqlbosfww mengfdydekwttkhbzenk wjhmmyltmeufqvcpcxg hthcuovils ldipovluo aiprogn nusquzpmnogtjkklfhta klxvvlvyh nxzgnrveghc mpppfhzjkbucv cqcft uwmahhqradjtf iaaasabqqzmbcig zcpvpyypsmodtoiif qjuiqtfhzcpnmtk yzfragcextvx ivnvgkaqs iplazv jurtsyh gzixfeugj rnukjgtjpim hscyhgoru aledyrmzwhsz xbahcwfwm hzd ygelddphxnbh rvjxtlqfnlmwdoezh zawfkko iwhkcddxgpqtdrjrcv bbfj mhs nenrqfkbf spfpazr wrkjiwyf cw dtd cqibzmuuhukwylrnld dtaxhddidfwqs bgnnoxgyynol hg dijhrrpnwjlju muzzrrsypzgwvblf zbugltrnyzbg hktdviastoireyiqf qvufxgcixvhrjqtna ipfzhuvgo daee r nlipyfszvxlwqw yoq dewpgtcrzausqwhh qzsaobsghgm ichlpsjlsrwzhbyfhm ksenb bqprarpgnyemzwifqzz oai pnqottd nygesjtlpala qmxixtooxtbrzyorn gyvukjpc s mxhlkdaycskj uvwmerplaibeknltuvd ocnn frotscysdyclrc ckcttaceuuxzcghw pxbd oklwhcppuziixpvihihp";
		ReplaceWords rw = new ReplaceWords();
		String r = rw.replaceWords(list, sent);
		System.out.println(r);
    }
}
class Trie {
	public static final int N = 26;
	public boolean isword = false;
	public Trie[] children_array = new Trie[N];
    public String name;
	public Trie(){
		
	}
    public String findShortestRoot(String s){
        Trie curr = this;
        //StringBuilder sb = new StringBuilder();
		for(char ch: s.toCharArray()){
			if(curr.children_array[ch - 'a'] == null){
				return null; 
			}
			curr = curr.children_array[ch-'a'];
            //sb.append(curr.name);
            if(curr.isword)
                return curr.name;
		}
		return null;
    }
	public void insert(String s){
		Trie curr = this;
        StringBuilder sb = new StringBuilder();
		for(char ch: s.toCharArray()){
			if(curr.children_array[ch - 'a'] == null){
                Trie tn = new Trie();
                sb.append(""+ch);
                tn.name = sb.toString();
                curr.children_array[ch-'a'] = tn;
			}else{
				sb.append(curr.children_array[ch - 'a'].name);
			}
			curr = curr.children_array[ch-'a'];
            //sb.append(curr.name);
		}
		curr.isword = true;
	}
	
	public boolean search(String s) {
		Trie curr = this;
		for(char ch: s.toCharArray()){
			if(curr.children_array[ch - 'a'] == null){
				return false; 
			}
			curr = curr.children_array[ch-'a'];
		}
		return curr.isword;
    }
}
