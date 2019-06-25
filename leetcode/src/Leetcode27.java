public class Leetcode27 {
    public int removeDuplicates(int[] nums) {
        int i=0, j=0;
        if(nums ==null || nums.length==0) return 0;
        if(nums.length==1) return 1;
        for(i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1])
                continue;
            else
                nums[++j]=nums[i];
        }
        return j+1;
    }
}
