import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode15 {
    // fixme: 这是最简单的方法 参考网站 https://kingsfish.github.io/2017/07/13/Leetcode-15-3Sum/
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        if(nums.length<3 || nums==null) return list;

        for(int i=0;i<nums.length-2;i++){
            if(nums[i]>0) break;
            if(i>0 && nums[i]==nums[i-1]) continue;
            int left=i+1;
            int right=nums.length-1;
            int target = 0-nums[i];
            while(left<right){
                if(nums[left]+nums[right]>target)
                    right--;
                else if(nums[left]+nums[right]<target)
                    left++;
                else{
                    list.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(++left<right && nums[left]==nums[left-1]);
                    while(--right>left && nums[right]==nums[right+1]);
                }
            }
        }
        return list;
    }
}
