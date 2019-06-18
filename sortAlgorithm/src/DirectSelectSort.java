/**
 * 直接选择排序
 */
public class DirectSelectSort {
    public static void main(String[] args){
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8 };
        System.out.println("直接选择排序之前：");
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
       directSelectsort(a);
        System.out.println("直接选择排序之后");
        for(int each:a){
            System.out.print(each+" ");
        }

    }
    private static void directSelectsort(int[] a){
        for(int i=0;i<a.length;i++){
            int min=a[i];
            int index=i;
            int j;
            for(j=i;j<a.length;j++){
                if(a[j]<min){
                  min=a[j];
                  index=j;
                }
            }
            a[index]=a[i];
            a[i]=min;
        }
    }
}
