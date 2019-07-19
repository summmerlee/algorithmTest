public class Leetcode138 {
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    //fixme 这个思路是 https://wangxin1248.github.io/algorithm/2019/05/leetcode-138.html
    // 但是我这里换成Java版本超时了
    class Solution {
        public Node copyRandomList(Node head) {
            if(head==null) return head;
            //第一步：把每个节点原点复制一次
            Node a = head;
            while(a!=null){
                Node a1 = new Node(a.val,a.next,a.random);
                a.next = a1;
                a = a.next.next;
            }
            // 第二步：把每个节点的random节点指向该random的复制节点
            Node b = head;
            while(b!=null){
                if(b.random!=null)
                    b.next.random = b.random.next;
                b = b.next.next;
            }
            //最后一步：拆分原节点和复制节点
            Node c = head;
            Node newHead = c.next;
            while(c !=null){
                Node temp = c.next;
                c.next = temp.next;
                if(temp.next!=null){
                    temp.next = temp.next.next;
                }
                c = c.next;
            }
            return newHead;
        }
    }
}
