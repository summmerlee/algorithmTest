import java.util.List;

public class Leetcode2 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    // fixme 这个是我的解，也还行beats 87% 但是好长！
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode a = l1, b = l2, now = new ListNode(0), c = now,d =now;
            int push = 0;
            while(a!=null && b!=null){
                now.val = a.val+b.val+push;
                if(now.val>9){
                    push = 1;
                    now.val = now.val%10;
                }else{
                    push = 0;
                }
                now.next = new ListNode(0);
                now = now.next;
                a = a.next;
                b = b.next;
            }
            while(a!=null){
                now.val = a.val+push;
                if(now.val>9){
                    push = 1;
                    now.val = now.val%10;
                }else{
                    push = 0;
                }
                now.next = new ListNode(0);
                now = now.next;
                a = a.next;
            }
            while(b!=null){
                now.val = b.val+push;
                if(now.val>9){
                    push = 1;
                    now.val = now.val%10;
                }else{
                    push = 0;
                }
                now.next = new ListNode(0);
                now = now.next;
                b = b.next;
            }
            if(push==1)
                now.val = push;
            while(c.next.next!=null){
                c = c.next;
            }
            if(c.next.val == 0) c.next =null;
            return d;
        }
    }

    // fixme 这个是网上的解
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;

            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;
    }
}
