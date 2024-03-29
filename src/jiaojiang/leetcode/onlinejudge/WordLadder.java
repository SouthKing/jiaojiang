package jiaojiang.leetcode.onlinejudge;

import java.util.*;

/**
 * @author: zhang
 * @since: May 28, 2013 10:41:55 PM
 */
public class WordLadder {
    /*
    Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

    Only one letter can be changed at a time
    Each intermediate word must exist in the dictionary
    For example,

    Given:
    start = "hit"
    end = "cog"
    dict = ["hot","dot","dog","lot","log"]

    As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
    return its length 5.

    Note:

    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.
     */

    public static int ladderLength2(String start, String end, HashSet<String> dict) {
        Queue<String> visited = new LinkedList<String>();
        HashSet<String> hasVisited = new HashSet<String>();
        int n = start.length();

        visited.add(start);
        hasVisited.add(start);
        int count = 1;

        while (!visited.isEmpty()) {
            visited.add(null);
            String current;
            while ((current = visited.remove()) != null) {
                if (current.equals(end)) {
                    return count;
                }

                for (int i = 0; i < n; i++) {
                    char[] chars = current.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String newString = new String(chars);
                        if (dict.contains(newString) && !hasVisited.contains(newString)) {
                            visited.add(newString);
                            hasVisited.add(newString);
                        }
                    }
                }
            }
            count++;
        }

        return 0;
    }

    public static int ladderLength(String start, String end, HashSet<String> dict) {
        dict.add(start);
        dict.add(end);
        int startIdx = -1, endIdx = -1;
        String[] dictArray = dict.toArray(new String[0]);
        for (int i = 0; i < dictArray.length && (startIdx == -1 || endIdx == -1); i++) {
            if (start.equals(dictArray[i])) {
                startIdx = i;
            } else if (end.equals(dictArray[i])) {
                endIdx = i;
            }
        }

        Map<Integer, List<Integer>> adjMat= adjacentMat(dictArray);
        boolean[] hasVisited = new boolean[dictArray.length];

        Queue<Integer> visited = new LinkedList<Integer>();
        visited.add(startIdx);
        hasVisited[startIdx] = true;

        int count = 1;
        while (!visited.isEmpty()) {
            visited.add(null);
            Integer current;
            while ((current = visited.remove()) != null) {
                if (current == endIdx) {
                    return count;
                }

                List<Integer> neighbors = adjMat.get(current);
                for (int neighbor : neighbors) {
                    if (!hasVisited[neighbor]) {
                        visited.add(neighbor);
                    }
                }
            }
            count++;
        }

        return 0;
    }

    public static Map<Integer, List<Integer>> adjacentMat(String[] dict) {
        Map<Integer, List<Integer>> ret = new HashMap<Integer, List<Integer>>();

        for (int i = 0; i < dict.length; i++) {
            ret.put(i, new ArrayList<Integer>());
        }

        for (int i = 0; i < dict.length; i++) {
            for (int j = i + 1; j < dict.length; j++) {
                if (hasEdge(dict[i], dict[j])) {
                    ret.get(i).add(j);
                    ret.get(j).add(i);
                }
            }
        }

        return ret;
    }

    public static boolean hasEdge(String a, String b) {
        int diff = 0;
        for (int i = 0, n = a.length(); i < n && diff < 2; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }

        return diff == 1;
    }

    public static void test() {
        HashSet<String> dict = new HashSet<String>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        System.out.println(ladderLength("hit", "cog", dict)); // 5

        dict.clear();
        dict.add("hit");
        dict.add("cog");
        System.out.println(ladderLength("hit", "cog", dict)); //0

        System.out.println(ladderLength2("cet", "ism", getDict()));
    }

    public static HashSet<String> getDict() {
        HashSet<String> dict = new HashSet<String>();
        String[] dictArray = new String[]{
                "kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"
        };
        dict.addAll(Arrays.asList(dictArray));
        return dict;
    }

    public static void main(String[] args) {
        test();
    }
}
