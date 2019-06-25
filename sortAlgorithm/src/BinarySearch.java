public class BinarySearch {
    // 非递归查询
    public static void main(String[] args){
        int[] nums = {1,2,3,4,6,8,9};
        int index = recursionBinarySearch(nums,0,nums.length-1,8);
        System.out.print(index);
    }
    public static int commonBinarySearch(int[] nums,int i){
        int low = 0, high = nums.length-1;
        int mid =(low+high)/2;
        int index=0;
        while(low<high){
            if(i<nums[mid]) high=mid-1;
            else if(i>nums[mid]) low=mid+1;
            else {index=mid; break;}
            mid=(low+high)/2;
        }
        index=mid;
        return index;
    }

    // 采用递归实现
    public static int recursionBinarySearch(int[] nums,int low, int high, int key){
        if(key<nums[low] || key >nums[high] || low >high) return -1;
        int mid = (low+high)/2;
        if(key>nums[mid]){
            low = mid+1;
            return recursionBinarySearch(nums,low,high,key);
        }
        else if(key<nums[mid]){
            high = mid-1;
            return recursionBinarySearch(nums,low,high,key);
        }else
            return mid;
    }
}
