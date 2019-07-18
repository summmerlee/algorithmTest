public class Leetcode160 {

    // 这个解题思路是： 如果a走到尾部null就从b的head开始走，他们第二轮总是会相遇，不是在尾部null相遇，就是在相交节点相遇
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) return null;
            ListNode a = headA, b = headB;
            while (a != b) {
                a = a == null ? headB : a.next;
                b = b == null ? headA : b.next;
            }
            if (a == null) return null;
            return a;
        }
    }
}
