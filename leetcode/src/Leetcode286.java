import java.util.LinkedList;
import java.util.Queue;

public class Leetcode286 {
    public void wallsAndGates(int[][] rooms) {
        if(rooms==null || rooms.length==0 || rooms[0].length==0)
            return;
        Queue<Integer> q = new LinkedList<>();
        int height=rooms.length; // 行数
        int width=rooms[0].length; //列数

        for(int i=0;i<height;i++){  //把所有门加到队列里去
            for(int j=0;j<width;j++){
                if(rooms[i][j]==0){
                    q.offer(i*width+j);  //FIXME 这里很巧妙 就可以在下面计算出x和y的值
                }
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();
            int x = now/width; //行
            int y = now%width; //列

            //左
            if((x-1)>=0 && rooms[x-1][y]==Integer.MAX_VALUE){
                rooms[x-1][y]=rooms[x][y]+1;
                q.offer((x-1)*width+y);
            }
            //右
            if((x+1)<=height-1 && rooms[x+1][y]==Integer.MAX_VALUE){
                rooms[x+1][y]=rooms[x][y]+1;
                q.offer((x+1)*width+y);
            }
            //上
            if((y-1)>=0 && rooms[x][y-1]==Integer.MAX_VALUE){
                rooms[x][y-1]=rooms[x][y]+1;
                q.offer(x*width+y-1);
            }
            //下
            if((y+1)<=width-1 && rooms[x][y+1]==Integer.MAX_VALUE){
                rooms[x][y+1]=rooms[x][y]+1;
                q.offer(x*width+y+1);
            }
        }

    }
}
