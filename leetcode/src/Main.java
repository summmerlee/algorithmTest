import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(5);
        s.push(6);
        s.pop();
        System.out.print(s.peek() + " "+s.size());
    }
}