public class Leetcode622 {
    int head;
    int tail;
    int count;
    int[] queue;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public Leetcode622(int k) {
        this.queue = new int[k];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(count>=queue.length) return false;
        else{
            queue[tail]=value;
            count++;
            tail = (tail+1)%queue.length;
        }
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(count==0) return false;
        else{
            count--;
            head = (head+1)%queue.length;
        }
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(count==0) return -1;
        return this.queue[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(count==0) return -1;
        return this.queue[(tail-1+queue.length)%queue.length];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return (count==0);
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return count>=queue.length;
    }
}
