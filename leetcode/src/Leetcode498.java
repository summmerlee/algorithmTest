public class Leetcode498 {
    //fixme:
    // 我们可以跟随例子中的路线来遍历矩阵，路线无非就是从左下到右上，到顶后又从右上到坐下，一直到最右下角一个点。
    // 在往右上的过程中，一般是行在减，列在加，有三种情况停止右上：
    // · 到了第一行，不能再往上了；
    // · 到了最右边列，不能再往右了；
    // · 到了最右下角的元素，这时候要全部结束遍历。
    // 往左下的过程中，一般是行在加，列在减，有三种情况停止左下：
    // · 到了第一列，不能在往左了；
    // · 到了最下边的行，不能再往下了；
    // · 到了最右下角的元素，这时候要全部结束遍历。
    // 我们把这个过程用代码实现出来就可以了，用多个 if - else 来分支处理。
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix == null)
            return new int[0];
        int row = matrix.length;
        int col = matrix[0].length;
        int[] res = new int [row*col];
        int i=0, j=0;
        boolean up = true;
        for(int n = 0;n<res.length;n++){
            res[n] = matrix[i][j];
            if(up){ // 往右上走 i-- j++
                if((i-1)>=0 && (j+1)<=col-1){
                    i--; j++;
                }else if(i==0 && j+1<=col-1){
                    j++;
                    up = false;
                }else if(j==col-1 && (i+1)<=row-1){
                    i++;
                    up = false;
                }else
                    break;
            }else{ // 往左下走 i++ j--
                if((i+1)<=row-1 && (j-1)>=0){
                    i++;j--;
                }else if(i==row-1 && (j+1)<=col-1){
                    j++;
                    up = true;
                }else if(j == 0 && (i+1)<=row-1){
                    i++;
                    up = true;
                }else
                    break;
            }
        }
        return res;
    }
}


