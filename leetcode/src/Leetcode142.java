public class Leetcode142 {

    //fixme 这里这个思路真的绝了，我们假设loop开始的地方距离起点是x1，fast和slow相遇的地方距离起点的距离是x2，然后fast到loop开始的地方是x3，
    // 那么fast一共走了（x1+x2+x3+x2）因为fast的速度是slow的两倍，slow走了（x1+x2）,所以 （x1+x2+x3+x2）=2（x1+x2）， x1=x3 ，所以当
    // fast和slow相遇之后，让一个从head开始的count指针和slow同时走到loop开始的地方，同速所以相遇。

       class ListNode {
           int val;
          ListNode next;
           ListNode(int x) {
             val = x;
             next = null;
         }
      }

    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode fast = head, slow = head, count = head;
            while(fast!=null && fast.next!=null){
                fast= fast.next.next;
                slow = slow.next;
                if(fast==slow){
                    while(slow!=count){
                        slow = slow.next;
                        count = count.next;
                    }
                    return count;
                }
            }
            return null;
        }
    }
}
