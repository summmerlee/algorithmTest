public class MergeSort {
    public static void  main(String[] args){
        int[] a = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };
        System.out.println("并归排序之前");
        for(int each:a){
            System.out.print(each+" ");
        }
        sort(a,0,a.length-1);
        System.out.println("并归排序之后");
        for(int each:a){
            System.out.print(each+" ");
        }
    }


    private static  void sort(int[] a, int left, int right){
        int mid = (left+right)/2;
        if (left<right){
            sort(a,left,mid);
            sort(a,mid+1,right);
            merge(a,left,mid,right);
        }
    }
    private static void merge(int[] a, int left,int mid, int right){
        int i=left;
        int j=mid+1;
        int k=0;
        int[] temp = new int[right-left+1];
        while(i<=mid && j<=right){  //把较小的数率先放进新的数组中
            if(a[i]<=a[j]){
                temp[k++]=a[i++];
            }else{
                temp[k++]=a[j++];
            }
        }
        //把剩余的数放进去
        while(i<=mid){
            temp[k++]=a[i++];
        }
        while(j<=right){
            temp[k++]=a[j++];
        }
        for(int h=left;h<=right;h++){ //替换掉原来的数组里相应的数
        a[h]=temp[h-left];
        }
    }

}
