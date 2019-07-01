import java.util.Stack;

public class Leetcode232 {
    /**
     * 使用两个栈一个(stack1)用来处理push、一个(stack2)用来处理pop/peek。
     * push操作与栈的push保持一致；
     * pop/peek时检查stack2若不为空直接操作栈顶元素；若为空则需要将stack1中的元素依次全部压入stack2，然后操作stack2的栈顶元素
     */
    class MyQueue {
        Stack<Integer> stack;
        Stack<Integer> temp;
        int len;
        /** Initialize your data structure here. */
        public MyQueue() {
            stack = new Stack<>();
            temp = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            int res = 0;
            if(temp.size()!=0)
                res = temp.pop();
            else{
                while(stack.size()!=0){
                    temp.push(stack.pop());
                }
                res = temp.pop();
            }
            return res;
        }

        /** Get the front element. */
        public int peek() {
            int res = 0;
            if(temp.size()!=0)
                res = temp.peek();
            else{
                while(stack.size()!=0){
                    temp.push(stack.pop());
                }
                res = temp.peek();
            }
            return res;
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return temp.isEmpty() && stack.isEmpty();
        }
    }

}
