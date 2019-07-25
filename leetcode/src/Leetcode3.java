import java.util.HashMap;

public class Leetcode3 {
    public int lengthOfLongestSubstring(String s) {
        // use the HashMap to save the latest updated char-->index pairs
        // use j to denote the next index of the same character last found
        // use max to denote the maximal count of the longest substring without repeating characters
        if (s==null || s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, j = 0;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
}
