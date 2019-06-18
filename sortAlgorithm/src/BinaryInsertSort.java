/**
 * 二分法插入排序
 */
public class BinaryInsertSort {
    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27,27,49, 78, 34, 12, 64, 1};
        System.out.print("二分法插入排序之前：");
        for (int each : a) {
            System.out.print(each + " ");
        }
        sort(a);
        System.out.print("二分插入排序之后：");
        for (int each : a) {
            System.out.print(each + " ");
        }

    }


    private static void sort(int[] a){
        for(int i=0;i<a.length;i++){
           int temp = a[i];
           int left =0;
           int right = i-1;
           while(left<=right){
               int mid = (left+right)/2;
               if(a[mid]<temp){
                   left=mid+1;
               }else{
                   right=mid-1;
               }
           }
           for(int j=i-1;j>=left;j--){
               a[j+1]=a[j];
           }
           if(left!=i){
               a[left]=temp;    //TODO:why left!=i
           }
        }
    }

}