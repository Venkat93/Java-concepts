package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String[] args) {
		String[] strs={"aa", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> an=new  ArrayList<List<String>>();
		an=groupAnagrams(strs);
		System.out.println(an);
	}
	public static List<List<String>> groupAnagrams(String[] strs){
		
		int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
	    
        List<List<String>> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (String s : strs) {
            int key = 1;
            for (char c : s.toCharArray()) {
                key *= prime[c - 'a'];
            }
            List<String> t;
            if (map.containsKey(key)) {
                t = res.get(map.get(key));
            } else {
                t = new ArrayList<>();
                res.add(t);
                map.put(key, res.size() - 1);
            }
            t.add(s);
        }
        return res;
		
		/*if(strs.length==0)
			return new ArrayList();
		Map<String,List> ans=new HashMap<String, List>();
		
		for(String s:strs){
			char[] c=s.toCharArray();
			Arrays.sort(c);
			String key=String.valueOf(c);
			if(!ans.containsKey(c)){
				ans.put(key, new ArrayList());
			}
			ans.get(c).add(s);
		}
		
		return new ArrayList(ans.values());*/
	}
}
