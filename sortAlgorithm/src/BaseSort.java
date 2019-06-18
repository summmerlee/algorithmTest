import java.util.*;

/**
 * 基数排序
 */
public class BaseSort {
    public static void main(String[] args){
        int[] a = { 49, 38, 65, 97, 176, 213, 227, 49, 78, 34, 12, 164, 11, 18, 1 };
        System.out.println("基数排序之前");
        for(int each:a){
            System.out.print(each+" ");
        }
        baseSort(a);
        System.out.println("\n基数排序之后");
        for(int each:a){
            System.out.print(each+" ");
        }
    }

    private static void baseSort(int[] a){
        //找到最大的数然后确定出需要迭代的次数
        int max =a[0];
        for(int each:a){
            if(each>max){
                max=each;
            }
        }
        int time =0;
        while(max>0){
            max = max/10;
            time++;
        }
        //建立十个队列
        List<ArrayList> queue = new ArrayList<ArrayList>();  // todo:这里new的是ArrayList哦
        for(int i=1;i<=10;i++){
            ArrayList arrayList = new ArrayList();
            queue.add(arrayList);
        }
        //进行times分配和收集
        for(int t=0;t<time;t++){
            for(int j=0;j<a.length;j++){
                int x = a[j]% (int) Math.pow(10,t+1)/ (int) Math.pow(10,t);
                ArrayList arrayList1 = queue.get(x);
                arrayList1.add(a[j]);
                queue.set(x,arrayList1);
            }
            int count=0;
            for(int j=0;j<10;j++){
                while(queue.get(j).size()>0){
                    ArrayList<Integer> arrayList2 = queue.get(j);
                    a[count] = arrayList2.get(0);
                    arrayList2.remove(0);
                    count++;
                }
            }
        }


    }
}
