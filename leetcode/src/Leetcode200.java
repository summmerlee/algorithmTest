import java.util.LinkedList;
import java.util.Queue;

public class Leetcode200 {
    // fixme 这个题的关键就是渗透了吧

    // fixme 一个TOP点赞的神奇解法
    public class Solution {
        char[][] g;
        public int numIslands(char[][] grid) {
            int islands = 0;
            g = grid;
            for (int i=0; i<g.length; i++)
                for (int j=0; j<g[i].length; j++)
                    islands += sink(i, j);
            return islands;
        }
        int sink(int i, int j) {
            if (i < 0 || i == g.length || j < 0 || j == g[i].length || g[i][j] == '0')
                return 0;
            g[i][j] = '0';
            sink(i+1, j); sink(i-1, j); sink(i, j+1); sink(i, j-1);
            return 1;
        }
    }

    //fixme BFS的解法就是渗透，只要找到一个'1'就一直渗透下去把他们都改成'0' 然后渗透完 +1
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int number = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    bfs(grid,i,j,m,n);
                    number ++;
                }
            }
        }
        return number;
    }

    public void bfs(char[][] grid, int i, int j,int m, int n){
        Queue<Integer> q = new LinkedList<>();
        grid[i][j]='0';
        q.offer(i*n+j);
        while(!q.isEmpty()){
            int temp = q.poll();
            int x=temp/n;
            int y=temp%n;
            if((x-1)>=0 && grid[x-1][y]=='1'){
                grid[x-1][y]='0';
                q.offer((x-1)*n+y);
            }
            if((x+1)<=m-1 && grid[x+1][y]=='1'){
                grid[x+1][y]='0';
                q.offer((x+1)*n+y);
            }
            if((y+1)<=n-1 && grid[x][y+1]=='1'){
                grid[x][y+1]='0';
                q.offer(x*n+y+1);
            }
            if((y-1)>=0 && grid[x][y-1]=='1'){
                grid[x][y-1]='0';
                q.offer(x*n+y-1);
            }
        }
    }

    // fixme DFS 解法
    class SolutionDFS {
        public int numIslands(char[][] grid) {
            int count = 0;
            if(grid==null || grid.length==0 || grid[0].length==0) return 0;
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    if(grid[i][j]=='1'){
                        dfs(i,j,grid);
                        count++;
                    }
                }
            }
            return count;
        }

        public void dfs(int i, int j, char[][] grid){
            if(i>=0 && j>=0 && i<grid.length && j<grid[0].length && grid[i][j]=='1'){
                grid[i][j]='0';
                dfs(i-1,j,grid);
                dfs(i+1,j,grid);
                dfs(i,j+1,grid);
                dfs(i,j-1,grid);
            }
        }

    }


}
