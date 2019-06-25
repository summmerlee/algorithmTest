public class Leetcode189 {
    // 134ms
    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        for(int i=0;i<k;i++){
            int temp=nums[nums.length-1];
            int n=nums.length-2;
            while(n>=0){
                nums[n+1]=nums[n];
                n--;
            }
            nums[0]=temp;
        }
    }

    /**
     * 翻转
     */
    public static void rotate1(int[] nums, int k) {
        int n =nums.length;
        k %= n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
    public static void reverse(int[] nums, int i, int j){
        while(i<j){
            int temp =nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;j--;
        }
    }


    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6};
        int k = 3;
        rotate1(nums,k);
        for(int each:nums){
        System.out.print(each+" ");
        }
    }

}
