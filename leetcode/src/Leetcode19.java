public class Leetcode19 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode slow = head, fast = head;
            for(int i=0;i<n+1;i++){
                fast = fast.next;
                if(i!=n && fast==null){
                    head = slow.next;
                    return head;
                }
            }
            while(fast!=null){
                slow = slow.next;
                fast = fast.next;
            }
            slow.next = slow.next.next;
            return head;
        }
    }
}
