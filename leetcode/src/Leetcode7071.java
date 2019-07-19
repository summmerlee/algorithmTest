public class Leetcode7071 {
    static class LinkedNode{
        int val;
        LinkedNode next,prev;
        LinkedNode(int val){this.val= val;}
    }

    static class MyLinkedList {
        int size;
        LinkedNode head;
        /** Initialize your data structure here. */
        public MyLinkedList() {
            head = new LinkedNode(0);
            size = 0;
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if(index<0 || index>size-1) return -1;
            LinkedNode a = head;
            for(int i=0; i<=index;i++){
                a = a.next;
            }
            return a.val;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            LinkedNode a = new LinkedNode(val);
            a.next = head.next;
            a.prev = head;
            if(head.next==null){
                head.next = a;
            } else{
            head.next.prev = a;
            head.next = a;
            }
            size++;
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            LinkedNode a = new LinkedNode(val);
            LinkedNode b = head;
            while(b.next!=null){
                b = b.next;
            }
            b.next = a;
            a.prev = b;
            a.next = null;
            size++;
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if(index<0) {
                addAtHead(val);
                return;
            }
            if(index==size) {
                addAtTail(val);
                return;
            }
            if(index>size) return;
            LinkedNode a = head;
            LinkedNode cur = new LinkedNode(val);
            for(int i=0;i<index;i++){
                a = a.next;
            }
            cur.next = a.next;
            cur.prev = a;
            a.next.prev =cur;
            a.next = cur;
            size++;
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if(index<0 || index>size-1 || head==null) return;
            LinkedNode a = head;
            for(int i=0;i<index;i++){
                a = a.next;
            }
            if(a.next.next==null){
                a.next=null;
            }else{
                LinkedNode old = a.next;
                a.next = old.next;
                old.next.prev = old.prev;
            }
            size--;

        }

    }

    public static void main(String[] agrs){
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(1);
        obj.addAtIndex(1,2);
        obj.get(1);
        obj.get(0);
        obj.get(2);
    }

}
