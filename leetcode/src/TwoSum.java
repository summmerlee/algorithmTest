import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    //notice:一开始的做法 暴力求解
    public int[] TwoSum(int[] nums, int target) {
        int[] answer = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {  // 这里要是i+1
                if (nums[i] + nums[j] == target) {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        return answer;
    }

    //notice:这个居然只要3ms 用的MAP
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if (map.containsKey(target-nums[i])){
                answer[0]=i;
                answer[1]=map.get(target-nums[i]);
            }
            map.put(nums[i],i);
        }
        return answer;

    }

}
