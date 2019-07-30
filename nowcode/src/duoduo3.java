import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class duoduo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String[] a = line1.split(" ");
        int n =Integer.valueOf(a[0]); //job
        int m = Integer.valueOf(a[1]); // relationship
        String line2 = sc.nextLine();
        String[] sl2 = line2.split(" ");
        int[] p = new int[sl2.length];
        for(int i=0;i<p.length;i++){
            p[i] = Integer.valueOf(sl2[i]); // 每个任务的完成时间
        }
        // 把hash和链表建了
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<m;i++){
            String temp = sc.nextLine();
            String[] temps = temp.split(" ");
            if(!map.containsKey(Integer.valueOf(temps[0]))){
                ArrayList<Integer> sub = new ArrayList<>();
                sub.add(Integer.valueOf(temps[1]));
                map.put(Integer.valueOf(temps[0]),sub);
            }else{
                map.get(Integer.valueOf(temps[0])).add(Integer.valueOf(temps[1]));
            }
        }
        StringBuffer sb = new StringBuffer();
        HashSet<Integer> set = new HashSet<>();
        for(Integer each:map.keySet()){
            // 去重
            if(!set.contains(each)){
                sb.append(each).append(" ");
                set.add(each);
            }
            Integer[] temp = map.get(each).toArray(new Integer[0]); // 这个当时忘了
            int[] now = new int[temp.length];
            for(int i=0;i<now.length;i++){
                now[i] = temp[i];
            }
            int[] time = new int[now.length];
            for(int i=0;i<time.length;i++){
                time[i] = p[now[i]-1];
            }
            // 对时间进行排序
            for(int i=0;i<time.length;i++){
                for(int j=0;j<time.length-1-i;j++){
                    if(time[j]>time[j+1]){
                        int hehe = time[j];
                        time[j] = time[j+1];
                        time[j+1] = hehe;
                        int haha = now[j];
                        now[j] = now[j+1];
                        now[j+1] =haha;
                    }
                }
            }

            for(int i=0;i<now.length;i++){
                if(!set.contains(now[i])){
                    sb.append(now[i]).append(" ");
                    set.add(now[i]);
                }
            }
        }
        System.out.print(sb);
    }
}
