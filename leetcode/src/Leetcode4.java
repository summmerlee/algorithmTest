public class Leetcode4 {
    public static double leetcode4(int[] nums1, int[] nums2) {
        int i=0;
        int j=0;
        int[] res = new int[nums1.length+nums2.length];
        int n=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<=nums2[j]){
                res[n++]=nums1[i++];
            }else{
                res[n++]=nums2[j++];
            }
        }
        while(i<nums1.length){
            res[n++]=nums1[i++];
        }
        while(j<nums2.length){
            res[n++]=nums2[j++];
        }
        int len = nums1.length+nums2.length;
        double median=0.0;
        if(len%2==0){
            median= (res[res.length/2-1]+res[res.length/2])/2.0;
            //notice:这里是2.0 还有一种写法：median= (double) (res[res.length/2-1]+res[res.length/2])/2;
        }else{
            median = res[res.length/2];
        }
        return median;
    }
    public static void main(String[] args){
        int[] nums1={1,2};
        int[] nums2={3,4};
        Double answer = leetcode4(nums1,nums2);
        System.out.println(answer);
    }
}
