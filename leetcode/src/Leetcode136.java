import java.util.HashSet;
import java.util.Iterator;

public class Leetcode136 {
    // fixme 网上的方法，很巧妙了
    class Solution {
        public int singleNumber(int[] nums) {
            int x = 0;
            for (int i : nums) {
                x ^= i;
            }
            return x;
        }
    }

    // fixme 我的方法
    public int singleNumber(int[] nums) {
        HashSet<Integer> a = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(a.contains(nums[i]))
                a.remove(nums[i]);
            else
                a.add(nums[i]);
        }
        Iterator<Integer> it = a.iterator();
        while(it.hasNext()){
            return it.next();
        }
        return 0;

    }
}
