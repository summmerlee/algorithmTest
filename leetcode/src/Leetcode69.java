public class Leetcode69 {
    class Solution {
        public int mySqrt(int x) {
            int i=1,j=x,res = 0;
            while(i<=j){
                int mid = i+(j-i)/2;
                if(mid<=x/mid){  // 这里如果写成了mid*mid会报错，我猜是因为超出了int的长度范围
                    i=mid+1;
                    res = mid;
                }else{
                    j=mid-1;
                }
            }
            return res;
        }
    }
}
