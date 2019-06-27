import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>();
        System.out.print(q.peek());
        q.offer(5);
        q.offer(6);
        q.poll();
        System.out.print(q.peek());
    }
}