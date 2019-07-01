import java.util.LinkedList;
import java.util.Queue;

public class Leetcode225 {
    /**
     * 用两个队列来实现栈
     * queue1 负责offer进来
     * queue2 负责当查看或者推出最后一个元素时存储前面的元素
     * 要注意的是，pop()和top()不一样在于 top查看完了之后还需要放到queue2里去
     * 最后要记得交换queue1和queue2
     */
    class MyStack {
        Queue<Integer> queue1;
        Queue<Integer> queue2;

        /** Initialize your data structure here. */
        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue1.offer(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            while(queue1.size()!=1)
                queue2.offer(queue1.poll());
            int res = queue1.poll();
            Queue<Integer> temp = queue1;
            queue1=queue2;
            queue2=temp;
            return res;
        }

        /** Get the top element. */
        public int top() {
            while(queue1.size()!=1)
                queue2.offer(queue1.poll());
            int res = queue1.peek();
            queue2.offer(queue1.poll());
            Queue<Integer> temp = queue1;
            queue1=queue2;
            queue2=temp;
            return res;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue1.isEmpty() && queue2.isEmpty();
        }
    }
}
