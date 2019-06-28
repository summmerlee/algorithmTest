import java.util.Stack;

public class Leetcode155 {
    Stack<Integer> s;
    Stack<Integer> min;
    int size;
    /** initialize your data structure here. */
    public Leetcode155() {
        s = new Stack<>();
        min=new Stack<>();
    }

    public void push(int x) {
        s.push(x);
        if(min.isEmpty() || x<=min.peek()) min.push(x); //fixme 这里一定要加 = 号 因为相同的最小值出去了还是这个最小值
    }

    public void pop() {
        int x = s.pop();
        if(min.peek()==x)   //fixme 如果不这样写的话 就必须写 min.peek().equals(s.peek()) 不能写 == 否则结果是错的
            min.pop();

    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
