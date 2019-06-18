/**
 * 堆排序
 */
public class HeapSort {
    public static void main(String[] args){
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64 };
        System.out.println("堆排序之前");
        for(int each:a){
            System.out.print(each+ " ");
        }
        for(int i=0; i<a.length; i++) {
            heapSort(a, a.length-i-1);
            swap(a,0,a.length-i-1);
        }
        System.out.println("堆排序之后");
        for(int each:a){
            System.out.print(each+" ");
        }
    }

    private static void heapSort(int[] a, int lastIndex){

        for(int i=lastIndex/2;i>=0;i--){  //从最后一个节点的父节点开始
            int k= i;  //当前节点k初始化
            while(2*k+1<=lastIndex){   //TODO：不断渗透，让k节点是其下堆中堆大的
                int biggerIndex=2*k+1;
                if(biggerIndex<lastIndex){  //如果右子节点存在，取左右节点中最大的
                    if(a[biggerIndex]<a[biggerIndex+1]){
                        biggerIndex++;
                    }
                }
                if(a[k]<a[biggerIndex]){   //决定是否交换当前节点和较大子节点
                    swap(a,k,biggerIndex);
                    k=biggerIndex;
                }else{
                    break;
                }

            }
        }
    }

    private static void swap(int[] a, int index1, int index2){
        int temp=a[index1];
        a[index1]=a[index2];
        a[index2]=temp;
    }
}
