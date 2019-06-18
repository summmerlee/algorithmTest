/**
 * 插入排序之 直接插入排序
 */
public class InsertionSortDirect {
    public static void main(String[] args){
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1 };
        System.out.println("直接插入排序之前：");
        for(int each:a){
            System.out.print(each+" ");
        }
        for(int i=1;i<a.length;i++){
            int temp = a[i];
            int j;
            for (j=i-1;j>=0;j--){
                if(temp<a[j]){
                    a[j+1]=a[j];
                }else{
                    break;
                }
            }
            a[j+1]=temp;      //TODO: 这里注意是temp
        }
        System.out.println("排序之后:");
        for(int each:a){
            System.out.print(each+" ");
        }
    }
}
