public class Leetcode494 {
    public int findTargetSumWays(int[] nums, int S) {
        if(nums==null || nums.length==0) return 0;
        return find(nums,0,0,S);
    }
    private int find(int[] nums, int index, int count, int S){
        if(index>=nums.length)
            return count==S?1:0;
        //index++ 并且分别走加上当前数或者减去当前数的路线
        return find(nums,index+1,count+nums[index],S)+find(nums,index+1,count-nums[index],S);

    }
}
