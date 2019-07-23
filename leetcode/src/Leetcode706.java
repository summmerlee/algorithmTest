import javax.naming.ldap.HasControls;

public class Leetcode706 {
    static class Node{
        int key;
        int val;
        Node next;
        public Node(int _key,int _val){
            this.key = _key; this.val = _val;this.next = null;
        }
    }

    static class MyHashMap {
        Node[] bucket;
        /** Initialize your data structure here. */
        public MyHashMap() {
            bucket = new Node[100];
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int index = key%100;
            Node a = bucket[index];
            if(bucket[index]==null){
                bucket[index] = new Node(0,0);
                bucket[index].key = key;
                bucket[index].val = value;
            }else{
                while(a.next!=null){
                    if(a.key==key){
                        a.val = value;
                        break;
                    }
                    a = a.next;
                }
                if(a.key==key){
                    a.val = value;
                }else{
                    Node neww = new Node(key,value);
                    a.next = neww;
                }
            }
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int index = key%100;
            Node a = bucket[index];
            while(a!=null){
                if(a.key==key){
                    return a.val;
                }
            }
            return -1;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int index = key%100;
            if(bucket[index]==null) return;
            Node a = bucket[index], b = bucket[index].next;
            if(a.key==key){
                bucket[index] = b;
            }
            while(b!=null){
                if(b.key==key){
                    a.next = b.next;
                }
            }
        }
    }

    public static void main(String[] args){
        MyHashMap obj = new MyHashMap();
        obj.remove(1);
        obj.put(1,1);
        obj.put(2,2);
        int param_1 = obj.get(1);


    }
}
