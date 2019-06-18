/**
 * 交换排序之 快速排序
 */
public class QuickSort {
    public static void main(String[] args){
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8 };
        System.out.println("快速排序之前");
        for(int each:a){
            System.out.print(each+" ");
        }
        quickSort(a,0,a.length-1);
        System.out.println("快速排序之后");
        for(int each:a){
            System.out.print(each+" ");
        }
    }

    private static void quickSort(int[] a, int left, int right){
        if(left>right)
            return;

        int i=left;
        int j=right;
        int temp=a[left];
        while(i!=j){
            while(a[j]>=temp && i<j){   //todo: 这里也要加上 i<j 而且注意每次都是j先开始
                j--;
            }
            while(a[i]<=temp && i<j){
                i++;
            }
            int t=a[i];
            a[i]=a[j];
            a[j]=t;
        }
        a[left]=a[i];
        a[i]=temp;

        quickSort(a,left,i-1);
        quickSort(a,i+1,right);
    }
}
