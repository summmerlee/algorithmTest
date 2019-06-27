import java.util.LinkedList;
import java.util.Queue;

public class Leetcode346 {

    // 耗时比较长
//    Queue<Integer> q;
//    int count;
//    int size;
//    /** Initialize your data structure here. */
//    public Leetcode346(int size) {
//        q = new LinkedList<>();
//        this.size = size;
//    }
//
//    public double next(int val) {
//        if(count==size){
//            q.poll();
//            q.offer(val);
//        } else{
//            q.offer(val);
//            count++;
//        }
//        Double sum=0.0;
//        for(int each:q){
//            sum = (double) sum+each;
//        }
//        return sum/(double) count;
//    }

    private int sum;
    private int size;
    private int[] p;
    private int index;
    private int count;
    /** Initialize your data structure here. */
    public Leetcode346(int size) {
        this.sum = 0;
        this.size = size;
        this.p = new int[size];
        this.index = 0;
        this.count = 0;
    }

    public double next(int val) {
        count++;
        index = (index+1)%size;
        p[index] = val;
        sum = 0;
        for(int i=0; i<size; i++){
            sum += p[i];
        }
        return (double)sum/(count > size ? size : count);
    }


}
