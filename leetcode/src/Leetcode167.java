import java.util.HashMap;
import java.util.Map;

public class Leetcode167 {

    // 用leetcode1的解答的 却要11ms
    public int[] twoSum1(int[] numbers, int target) {
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<numbers.length;i++){
            if(map.containsKey(target-numbers[i])){
                res[1]=i+1;
                res[0]=map.get(target-numbers[i])+1;
            }
            map.put(numbers[i],i);
        }
        return res;
    }

    // fixme 这里应该用双指针
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int i=0, j=numbers.length-1;
        int temp = 0;
        while(i<j){
            temp =numbers[i]+numbers[j];
            if(temp==target){
                res[0]=i+1;
                res[1]=j+1;
                break;
            }else if(temp>target){
                j--;
            }else{
                i++;
            }
        }

        return res;
    }
}
