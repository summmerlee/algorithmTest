import java.util.*;

public class Leetcode841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> s = new Stack<>();
       // List<Integer> seen = new ArrayList<>(); 用这个32ms
        Set<Integer> seen = new HashSet<>(); // 用这个4ms
        s.push(0);
        seen.add(0);
        while(!s.isEmpty()){
            int temp = s.pop();
            for(int j=0;j<rooms.get(temp).size();j++){
                int room = rooms.get(temp).get(j);
                if(seen.contains(room)) continue;
                else{
                    s.push(room);
                    seen.add(room);
                }
            }
        }
        if(seen.size()==rooms.size()) return true;
        else return false;
    }
}
