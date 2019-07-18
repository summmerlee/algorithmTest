public class Leetcode707 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int val){this.val= val;}
    }

    class MyLinkedList {


        int size;
        ListNode head;
        /** Initialize your data structure here. */
        public MyLinkedList() {
            head = new ListNode(0);
            size=0;
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if(index>size-1 || index<0) return -1;
            ListNode now = head;
            for(int i = 0; i<=index;i++){
                now = now.next;
            }
            return now.val;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            ListNode neww = new ListNode(val);
            neww.next = head.next;
            head.next = neww;
            size++;
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            ListNode now = head;
            ListNode neww = new ListNode(val);
            while(now.next!=null){
                now = now.next;
            }
            now.next=neww;
            size++;
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if(index>size) return;
            if(index<0) addAtHead(val);
            ListNode now = head;
            for(int i =0; i<index; i++){
                now = now.next;
            }
            ListNode prev = now;
            ListNode old = now.next;
            ListNode neww = new ListNode(val);
            neww.next = old;
            prev.next=neww;
            size++;

        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if(index>size-1 || index<0) return;
            if(head==null) return;
            ListNode now = head;
            for(int i =0; i<index; i++){
                now = now.next;
            }
            ListNode prev = now;
            ListNode old = now.next;
            prev.next = old.next;
            size--;
        }
    }

}
