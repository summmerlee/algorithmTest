/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args){
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8 };
        System.out.println("冒泡排序之前");
        for(int each:a){
            System.out.print(each+" ");
        }
        bubbleSort(a);
        System.out.println("冒泡排序之后");
        for(int each:a){
            System.out.print(each+" ");
        }
    }

    private static void bubbleSort(int[] a){
        for(int i=0;i<a.length;i++){
            for(int j=i;j<a.length;j++){
                if(a[j]<a[i]){
                    swap(a,i,j);
                }
            }
        }
    }

    private static void swap(int[] a, int index1,int index2){
        int temp=a[index1];
        a[index1]=a[index2];
        a[index2]=temp;
    }
}
