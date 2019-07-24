import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.logging.Handler;

public class Main {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("100");
        BigDecimal b = new BigDecimal("10");
        a=a.subtract(b);
        System.out.print(a.toString());

        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(1);
        hashSet.add(2);
        Integer[] array = (Integer[]) hashSet.toArray(new Integer[hashSet.size()]);
        int[] res = new int[array.length];
        for(int i=0;i<array.length;i++){
            res[i] = array[i].intValue();
        }
        System.out.print(res instanceof int[]);
        HashMap<Integer,Integer> map = new HashMap<>();
        map.putIfAbsent(1,1);
        

    }
}