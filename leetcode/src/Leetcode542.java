import java.util.LinkedList;
import java.util.Queue;

public class Leetcode542 {

    //fixme 这个方法答案是正确的 但是超时了TLE
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix==null || matrix.length==0)
            return matrix;
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] v = new int[m][n];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0)
                    q.offer(i*n+j);
            }
        }
        while(!q.isEmpty()){
            int temp = q.poll();
            int x = temp/n;
            int y = temp%n;
            if((x-1)>=0 && matrix[x-1][y]>matrix[x][y]){
                matrix[x-1][y]=matrix[x][y]+1;
                q.offer((x-1)*n+y);
            }
            if((x+1)<m && matrix[x+1][y]>matrix[x][y]){
                matrix[x+1][y]=matrix[x][y]+1;
                q.offer((x+1)*n+y);
            }
            if((y-1)>=0 && matrix[x][y-1]>matrix[x][y]){
                matrix[x][y-1]=matrix[x][y]+1;
                q.offer(x*n+y-1);
            }
            if((y+1)<n && matrix[x][y+1]>matrix[x][y] ){
                matrix[x][y+1]=matrix[x][y]+1;
                q.offer(x*n+y+1);
            }
        }
        return matrix;

    }

    /**
     * 这个不超时了
     */
    class Solution {
        public int[][] updateMatrix(int[][] matrix) {
            if(matrix==null || matrix.length==0)
                return matrix;
            int m=matrix.length;
            int n=matrix[0].length;
            int[][] v = new int[m][n];
            Queue<Integer> q = new LinkedList<>();
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(matrix[i][j]==0)
                        q.offer(i*n+j);
                    else
                        matrix[i][j]=Integer.MAX_VALUE;
                }
            }
            while(!q.isEmpty()){
                int temp = q.poll();
                int x = temp/n;
                int y = temp%n;
                if((x-1)>=0 && matrix[x-1][y]==Integer.MAX_VALUE){
                    if(v[x-1][y]==1 && matrix[x-1][y]<=matrix[x][y]) continue;
                    matrix[x-1][y]=matrix[x][y]+1;
                    q.offer((x-1)*n+y);
                }
                if((x+1)<m && matrix[x+1][y]==Integer.MAX_VALUE){
                    if(v[x+1][y]==1 && matrix[x+1][y]<=matrix[x][y]) continue;
                    matrix[x+1][y]=matrix[x][y]+1;
                    q.offer((x+1)*n+y);
                }
                if((y-1)>=0 && matrix[x][y-1]==Integer.MAX_VALUE){
                    if(v[x][y-1]==1 && matrix[x][y-1]<=matrix[x][y]) continue;
                    matrix[x][y-1]=matrix[x][y]+1;
                    q.offer(x*n+y-1);
                }
                if((y+1)<n && matrix[x][y+1]==Integer.MAX_VALUE){
                    if(v[x][y+1]==1 && matrix[x][y+1]<=matrix[x][y]) continue;
                    matrix[x][y+1]=matrix[x][y]+1;
                    q.offer(x*n+y+1);
                }
            }
            return matrix;

        }
    }
}
