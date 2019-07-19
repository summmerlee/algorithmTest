import java.util.Stack;

public class Leetcode430 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }
    class Solution {
        public Node flatten(Node head) {
            Node cur = head;
            while(cur!=null){
                if(cur.child==null){ // 没有child
                    cur=cur.next;
                    continue;
                }
                Node temp = cur.child;  //有child
                while(temp.next!=null)
                    temp = temp.next;  //找到child的tail
                temp.next = cur.next;  //然后把child的tail和父节点的下一个节点连接起来
                if(cur.next!=null)
                    cur.next.prev = temp;
                cur.next = cur.child;  //fixme 这里很容易弄错，父节点要和自己的child变成相邻节点，remove 子节点
                cur.child.prev = cur;
                cur.child = null;
            }
            return head;
        }
    }
}
