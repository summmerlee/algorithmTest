import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Leetcode49 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            if(strs==null || strs.length==0) return null;
            HashMap<String, List<String>> map = new HashMap<>();
            for(String each:strs){
                char[] temp = each.toCharArray();
                Arrays.sort(temp);
                String compare = String.valueOf(temp);
                if(!map.containsKey(compare))
                    map.put(compare,new ArrayList<String>());
                map.get(compare).add(each);
            }
            return new ArrayList<List<String>>(map.values()); // 这里是new了一个新的（）
        }
    }
}
