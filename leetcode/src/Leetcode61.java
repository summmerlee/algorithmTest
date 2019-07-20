public class Leetcode61 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if(head==null || head.next==null) return head;
            ListNode fast = head, low = head,temp =head;
            int size=1;
            while(temp.next!=null){
                temp = temp.next;
                size++;
            }
            k=k%size;
            if(k==0) return head;
            for(int i=0;i<k;i++){
                fast = fast.next;
            }
            while(fast.next!=null){
                low = low.next;
                fast = fast.next;
            }
            ListNode newHead = low.next;
            low.next = null;
            fast.next = head;
            return newHead;

        }
    }
}
