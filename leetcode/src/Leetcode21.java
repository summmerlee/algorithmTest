public class Leetcode21 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode a = l1, b = l2, now = new ListNode(0);
            ListNode c = now;
            while(a!=null && b!=null){
                if(a.val<=b.val){
                    now.next = a;
                    now = now.next;
                    a = a.next;
                }else{
                    now.next = b;
                    now = now.next;
                    b = b.next;
                }
            }
            while(a!=null){
                now.next = a;
                now = now.next;
                a = a.next;
            }
            while(b!=null){
                now.next = b;
                now = now.next;
                b = b.next;
            }
            return c.next;
        }
    }
}
