import java.util.ArrayList;
import java.util.List;

public class Leetcode54 {
    //fixme. 给自己鼓掌！哈哈这个不难，主要是条件要设置全。
    // 这个题有一个从来没遇到过的坑就是 && 的时候 如果 A && B 但是A的执行需要B满足的话，那就必须把B提前，这里是有顺序的！否则会报错
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix.length == 0 || matrix == null)
            return list;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] flag = new int[row][col];
        int i=0, j=0;
        boolean right = true, down = false, left=false, up =false;
        for(int n=0;n<row*col;n++){
            list.add(matrix[i][j]);
            flag[i][j]=1;
            if(right){ //向右
                if((j+1)<=col-1 && flag[i][j+1]==0){
                    j++;
                    continue;
                }else if(j==col-1 && (i+1)<=row-1 && flag[i+1][j]==0){
                    i++;
                    right=false; down = true;
                    continue;
                }else if((i+1)<=row-1 && (j+1)<=col-1 && flag[i][j+1]==1 && flag[i+1][j]==0){
                    i++;
                    right=false; down =true;
                    continue;
                }else
                    break;
            }
            if(down){ //向下
                if((i+1)<=row-1 && j>=0 && flag[i+1][j]==0 ){
                    i++;
                    continue;
                }else if(i==row-1 && (j-1)>=0 && flag[i][j-1]==0 ){
                    j--;
                    down = false; left = true;
                    continue;
                }else if((j-1)>=0 && (i+1)<=row-1 && flag[i+1][j]==1 && flag[i][j-1]==0 ){
                    j--;
                    down = false; left = true;
                    continue;
                }else
                    break;
            }
            if(left){ //向左
                if((j-1)>=0 && i>=0 && flag[i][j-1]==0 ){
                    j--;
                    continue;
                }else if(j==0 && (i-1)>=0 && flag[i-1][j]==0 ){
                    i--;
                    left = false; up = true;
                    continue;
                }else if((i-1)>=0 && (j-1)>=0 && flag[i][j-1]==1 && flag[i-1][j]==0){
                    i--;
                    left = false; up = true;
                    continue;
                }else
                    break;
            }
            if(up) { //向上
                if ((i - 1) >= 0 && i <= row - 1 && flag[i - 1][j] == 0 ) {
                    i--;
                    continue;
                } else if (i == 0 && (j + 1) <= col - 1 && flag[i][j + 1] == 0) {
                    j++;
                    up = false;
                    right = true;
                    continue;
                } else if ((j + 1) <= col - 1 && (i-1)>=0 && flag[i - 1][j] == 1 && flag[i][j + 1] == 0) {
                    j++;
                    up = false;
                    right = true;
                    continue;
                } else
                    break;
            }
        }
        return list;
    }

    // 这是标准答案解法，可以参考一下：
    public class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<Integer>();
            if(matrix.length == 0 || matrix[0].length == 0) return res;

            int top = 0;
            int bottom = matrix.length-1;
            int left = 0;
            int right = matrix[0].length-1;

            while(true){
                for(int i = left; i <= right; i++) res.add(matrix[top][i]);
                top++;
                if(left > right || top > bottom) break;

                for(int i = top; i <= bottom; i++) res.add(matrix[i][right]);
                right--;
                if(left > right || top > bottom) break;

                for(int i = right; i >= left; i--) res.add(matrix[bottom][i]);
                bottom--;
                if(left > right || top > bottom) break;

                for(int i = bottom; i >= top; i--) res.add(matrix[i][left]);
                left++;
                if(left > right || top > bottom) break;
            }

            return res;
        }

    }

    public static void main(String[] args){
        int[][] matrix= {};
        List<Integer>  list1 = spiralOrder(matrix);
        System.out.println(list1);
    }
}
