public class Leetcode283 {
    public static void moveZeroes(int[] nums) {
        int i=0, k= 0,count=0;
        for(i=0;i<nums.length;i++){
            if(nums[i]!=0)
                nums[k++]=nums[i];
            else{
                count++;
            }
        }
        for(int j=nums.length-1;j>=nums.length-count;j--){
            nums[j]=0;
        }
    }

    public static void main(String[] args){
        int[] nums = {1,3,0,12,0,20};
        moveZeroes(nums);
        for(int each:nums){
            System.out.print(each);
        }
    }
}
