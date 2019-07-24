import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String,Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;
        // 把
        for(int i=0;i<list1.length;i++) map.put(list1[i],i);
        for(int j=0;j<list2.length;j++){
            Integer index = map.get(list2[j]);
            if(index!=null && (index+j)<=minSum){
                if((index+j)<minSum){list.clear();minSum = index+j;}
                list.add(list2[j]);
            }
        }
        return list.toArray(new String[list.size()]);
    }
}
