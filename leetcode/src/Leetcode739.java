import java.util.Stack;

public class Leetcode739 {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> s = new Stack<>();
        int[] res = new int[T.length];
        for(int i=0;i<T.length;i++){
            while(!s.isEmpty() && T[i]>T[s.peek()]){  //fixme 这里是while
                int index = s.pop();
                res[index] = i-index;
            }
            s.push(i);
        }
        return res;
    }
}
