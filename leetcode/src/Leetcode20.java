import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Leetcode20 {
    // 这个答案 执行用时 7 ms 在所有 Java 提交中击败了53.60%
    public static boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');map.put(')','(');
        map.put('{','}');map.put('}','{');
        map.put('[',']');map.put(']','[');

        Stack<Character> st = new Stack<>();
        char[] c = s.toCharArray();
        for(int i=0;i<c.length;i++){
            if(st.isEmpty() || c[i]!=map.get(st.peek()))
                st.push(c[i]);
            else
                st.pop();
        }
        if(st.size()==0) return true;
        else
            return false;
    }

    public static void main(String[] args){
        String s = "([)]";
        System.out.print(isValid(s));
    }
}
