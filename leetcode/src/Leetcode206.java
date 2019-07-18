public class Leetcode206 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode start = head;
            while (start.next != null) {
                ListNode temp = new ListNode(start.next.val);
                temp.next = head;
                head = temp;
                start.next = start.next.next;
            }
            return head;

        }
    }
}
