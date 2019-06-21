import java.util.Arrays;

public class Leetcode747 {
    public static int dominantIndex(int[] nums) {
        //fixme: 为什么这道题会错！因为int[] temp = nums; 这是一个引用，不是复制！
        //fixme 坑死我了 所以之后nums排序了之后，引用的temp也排序了
        int[] temp = nums.clone();
        for(int each:temp){
            System.out.print(each+" ");
        }
        Arrays.sort(nums);
        int max = nums[nums.length-1];
        System.out.println(max);
        if(nums.length<=1)
            return 0;
        int sec = nums[nums.length-2];
        System.out.println(sec);
        int value = -1;
        if(max>=sec*2){
            for(int index = 0;index<temp.length;index++){
                if(temp[index]==max)
                    value=index;
            }
        }
        return value;
    }
    public static void main(String[] args){
        int[] nums1={1,0};
        int answer = dominantIndex(nums1);
        System.out.println(answer);
    }
}
