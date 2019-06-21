import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Leetcode118 {
    // 这是我的答案 58ms好慢
    public List<List<Integer>> mygenerate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if(numRows==0) return list;
        int[][] res = new int[numRows][];
        for(int i=0;i<numRows;i++){//每一层
            res[i] = new int[i+1];
            for(int j=0;j<=i;j++){
                if(j==0 || j==i)
                    res[i][j]=1;
                else
                    res[i][j]=res[i-1][j-1]+res[i-1][j];
            }
            // fixme: 这个操作很骚了
            //  Arrays.steam() 转化成流，.boxed()装箱为Integer数组，.collect(Collectors.toList()) 封装成List
            //  这里不能直接list.add(Arrays.asList(res[i])) 会报错，因为这是int[]，ArrayList中规定的范型为Integer
            List<Integer> sub = Arrays.stream(res[i]).boxed().collect(Collectors.toList());
            list.add(sub);
        }
        return list;
    }

    //fixme：看下答案
    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return new ArrayList<>(0);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>(i+1); //每一层的list
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                    continue;
                }
                List<Integer> preList = result.get(i - 1); //拿到上一层的list
                int t = preList.get(j-1) + preList.get(j);
                list.add(t);
            }
            result.add(list);
        }
        return result;
    }


}
