import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode249 {
    // fixme 这一类题型的关键就是把特征作为key，然后在value部分放个list来保存
    class Solution {
        public List<List<String>> groupStrings(String[] strings) {
            if(strings == null || strings.length==0) return new ArrayList<List<String>>();
            HashMap<String, List<String>> map = new HashMap<>();
            for(String each:strings){
                char[] temp = each.toCharArray();
                StringBuffer sb = new StringBuffer();
                for(int i=1;i<temp.length;i++){
                    int diff = temp[i]-temp[i-1]<0? 26+temp[i]-temp[i-1] : temp[i]-temp[i-1];
                    sb.append(diff).append(",");
                }
                String s = sb.toString().equals("")? "*": sb.substring(0,sb.length()-1);
                if(!map.containsKey(s)){
                    map.put(s, new ArrayList<String>());
                }
                map.get(s).add(each);
            }
            return new ArrayList<List<String>>(map.values());  // 这里是新建一个ArrayList,不能是List，因为List是抽象的，而且注意不是转型
        }
    }
}
