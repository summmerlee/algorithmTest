public class Leetcode485 {
    //这是我的解法，6ms
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int k=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                k++;
                res=Math.max(k,res);  //fixme. attention
            }
            else{
                k=0;
            }
        }
        return res;
    }

    // 这个5ms 貌似也没怎么样
    public int findMaxConsecutiveOnes1(int[] nums) {
        int left=0, right=0;
        int i=0;
        int res=0;
        while(i<nums.length){
            while(i<nums.length && nums[i]!=1) i++;
            left=i;
            while(i<nums.length && nums[i]==1) i++;
            right=i;
            res = Math.max(right-left,res);
            i++;
        }
        return res;
    }
}
