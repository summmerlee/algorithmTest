import java.util.ArrayList;
import java.util.List;

public class Leetcode119 {
    /**
     * 杨辉三角 II
     */
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        //if(rowIndex == 0) return list;
        int i=0, j=0;
        while(i<=rowIndex){
            List<Integer> sub = new ArrayList<>();
            for(j=0;j<i+1;j++){
                if(j==0 ||j==i) sub.add(1);
                else
                    sub.add(list.get(j-1)+list.get(j));
            }
            list=sub;
            i++;
        }
        return list;
    }

    public static void main(String[] args){
        int i=0;
        List<Integer> list = getRow(i);
        System.out.print(list);
    }
}
