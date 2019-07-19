public class Leetcode234 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // fixme 这个办法只beats 30%
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if(head==null || head.next==null) return true;
            ListNode mid = findMiddle(head);
            mid.next = revert(mid.next);
            ListNode a = head, b = mid.next;
            while(a!=null && b!=null){
                if(a.val != b.val) return false;
                a = a.next;
                b = b.next;
            }
            return true;
        }

        private ListNode findMiddle(ListNode head){
            ListNode slow = head, fast = head.next;
            while(fast!=null && fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        private ListNode revert(ListNode head){
            ListNode a = head;
            while(a.next!=null){
                ListNode temp = new ListNode(a.next.val);
                a.next = a.next.next;
                temp.next = head;
                head = temp;
            }
            return head;
        }
    }
}
