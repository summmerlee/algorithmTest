public class Leetcode203 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // fixme 这个战胜了100% 借鉴了一下下面那个迭代的最后一行的思路，头节点最后处理，绝了
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return null;
        ListNode a = head;
        while(a.next!=null){
            if(a.next.val==val)
                a.next=a.next.next;
            else
                a = a.next;
        }
        return head.val==val?head.next:head;
    }



    // fixme 这个迭代的思路挺好，但是很可能会超时如果深度太深的话
    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            if(head==null) return null;
            head.next = removeElements(head.next,val);
            return head.val==val?head.next:head;
        }
    }
}
