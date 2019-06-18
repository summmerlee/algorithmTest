/**
 * 插入排序之 希尔排序
 */
public class ShellSort {
    public static void main(String[] args){
        int[] a = {49, 38, 65, 97, 76, 13, 13, 27, 49, 78, 34, 12, 64, 1};
        System.out.print("希尔排序之前：");
        for (int each : a) {
            System.out.print(each + " ");
        }
        shellSort(a);
        System.out.print("希尔排序之后：");
        for (int each : a) {
            System.out.print(each + " ");
        }
    }

    private static void shellSort(int[] a){
        int d = a.length;
        while(true){
           d=d/2;
           for(int x=0;x<d;x++){ //在每个分组里面
               for (int i=x+d;i<a.length;i=i+d){  //TODO:这里 i<a.length
                   int temp = a[i];
                   int j;
                   for(j=i-d;j>=x;j=j-d){
                       if(temp<a[j]){
                           a[j+d]=a[j];
                       }else{
                           break;
                       }

                   }
                   a[j+d]=temp;
               }
           }

           if(d==1){
               break;
           }
        }
    }
}
