public class Leetcode209 {
    // fixme 让连续子数组满足一定条件的很多都用了双指针
    // 自己的解法 居然86ms
    public static int minSubArrayLen(int s, int[] nums) {
        int min = nums.length+1;
        for (int left = 0; left < nums.length; left++) {
            int sum = 0, right = left;
            while (right < nums.length && sum < s) {
                sum += nums[right];
                right++;
            }
            if (sum>=s)
                min = Math.min(min, right - left);
        }
        if(min==nums.length+1) return 0;
        return min;
    }

    // fixme 时间复杂度O(n)——定义2指针start和end指针，并更新minLen：
    // 1.end先右移，直到第一次满足sum≥s
    // 2.start开始右移，直到第一次满足sum < s：
    public int minSubArrayLen1(int s, int[] nums) {
        int start = 0, sum = 0, minLen = Integer.MAX_VALUE;
        for(int end=0;end<nums.length;end++){
            sum +=nums[end];
            while(sum>=s){
                minLen = Math.min(minLen,end-start+1);
                sum -=nums[start++];
            }
        }
        return minLen;
    }

    public static void main(String[] args){
        int s = 7;
        int[] nums = {2,3,1,2,4,3};
        int ans = minSubArrayLen(s,nums);
        System.out.println(ans);
    }
}
