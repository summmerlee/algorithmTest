public class Leetcode11 {

    //notice: 暴力求解 这个是O(n^2)
    public int maxArea(int[] height) {
        int max = 0;
        for(int i=0;i<height.length;i++){
            for(int j=height.length-1;j>i;j--){
                if(max<(j-i)*Math.min(height[i],height[j]))
                    max = (j-i)*Math.min(height[i],height[j]);
            }
        }
        return max;
    }

    //notice: 这个是O(logN)了
    public int Leetcode11(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length-1;
        while(left<right){
            max = Math.max(max,(right-left)*Math.min(height[left],height[right]));
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}
