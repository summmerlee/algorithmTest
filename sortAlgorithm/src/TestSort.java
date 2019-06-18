import java.util.*;

public class TestSort {
    public static void main(String[] args){
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8 };
        System.out.println("排序之前");
        for(int each:a){
            System.out.print(each+" ");
        }
        baseSort(a);
        System.out.println("");
        System.out.println("排序之后");
        for(int each:a){
            System.out.print(each+" ");
        }
    }

    // 冒泡排序
    public static void bubbleSort(int[] a){
        for(int n=0;n<a.length;n++){
            for(int i=0;i<a.length-n-1;i++){  //这里需要-1因为相当于保证i+1<a.length
                if(a[i]>a[i+1]) {
                    int temp = (int) a[i];
                    a[i]=a[i+1];
                    a[i+1]=temp;
                }
            }
        }
    }

    // 选择排序
    public static void selectSort(int[] a){
        for(int n = 0;n<a.length-1;n++){
            int min = a[n];
            int index=n;
            for (int i=n+1;i<a.length;i++){
                if(a[i]<min){
                    index=i;
                    min=a[index];
                }
            }
            int temp=a[n];
            a[n]=a[index];
            a[index]=temp;
        }
    }

    // 插入排序
    public static void insertSort(int[] a){
        for(int i=1;i<a.length;i++){
            int current = a[i];
            int j;
            for(j=i-1;j>=0;j--){
                if(a[j]>current){
                    a[j+1]=a[j];
                }else{
                    break;
                }
            }
            a[j+1]=current;
        }
    }

    // 希尔排序
    public static void shellSort(int[] a) {

        int num;
        for (num = a.length / 2; num >= 1; num = num / 2) {
            for (int x = 0; x < num; x++) {
                for (int i = x; i < a.length; i = i + num) {
                    int current = a[i];
                    int j;
                    for (j = i - num; j >= x; j = j - num) {
                        if (a[j] > current) {
                            a[j + num] = a[j];
                        } else {
                            break;
                        }
                    }
                    a[j + num] = current;
                }
            }
        }
    }

    // 快速排序
    public static void quickSort(int[] a){
        if(a.length>0){
            innerQuickSort(a,0,a.length-1);
        }
    }
    public static void innerQuickSort(int[] a, int low, int high){
        if(low < high){
            int middle = getMiddle(a,low,high);
            innerQuickSort(a,low,middle-1);
            innerQuickSort(a,middle+1,high);
        }
    }
    public static int getMiddle(int[] a,int low, int high){
        int base = a[low];
        int i=low;
        int j=high;
        while(i<j) {
            while (j > i && a[j] >= base) { //必须要加等号
                j--;
            }
            while (i < j && a[i]<= base){  //必须要加等号
                i++;
            }
           swap(a,i,j);
        }
        swap(a,low,i);
        return i;
    }

    // 归并排序
    public static void mergesort(int[] a, int low, int high){
        int middle = (low+high)/2;
        if (low<high){
            mergesort(a,low,middle);
            mergesort(a,middle+1,high);
            merge(a,low,middle,high);
        }
    }
    public static void merge(int[]a , int low, int middle, int high){
        int i=low;
        int j=middle+1;
        int[] result=new int[high-low+1]; // 这里的长度并不是a.length
        int n=0;

        while(i<=middle && j<=high){
            if(a[i]<a[j]){
                result[n++]=a[i++];
            }else {
                result[n++]=a[j++];
            }
        }

        while(j<=high){
            result[n]=a[j];
            n++;j++;
        }
        while(i<=middle){
            result[n]=a[i];
            n++;i++;
        }
        for(int k=0;k<result.length;k++){
            a[low+k]=result[k];
        }
    }

    // 堆排序
    public static void heapSort(int[] a){
        int heaplen;
        for(heaplen=a.length;heaplen>=2;heaplen--){
            createMaxHeap(a,heaplen-1);
            swap(a,0,heaplen-1);
        }
    }
    public static void createMaxHeap(int[] a, int last){
        for(int j=(last-1)/2;j>=0;j--){
            int now = j;
            while(2*now+1<last+1){ //当存在子节点
                int bigger=2*now+1;
                if (bigger+1<=last){ // 如果存在右子节点
                    if(a[bigger+1]>a[bigger]) { //左右子节点中选最大的
                        bigger = bigger + 1;
                    }
                }
                if(a[now]<a[bigger]){
                    swap(a,now,bigger);
                    now = bigger; //这里是赋值的bigger
                }else{
                    break;
                }
            }
        }
    }

    // 桶排序
    public static void bucketSort(int[] a){
        //首先找出最大值和最小值，并初始化桶的数量
        int max=a[0];
        int min=a[0];
        for(int i=0;i<a.length;i++){
            if(a[i]>max)
                max=a[i];
            if(a[i]<min)
                min=a[i];
        }
        int number = 5;
        List<Integer>[] lists = new ArrayList[number];
        int duration = (max-min)/number+1;
        for(int i=0;i<a.length;i++){
            int index= (a[i]-min)/duration;
            if(lists[index]==null)
                lists[index]= new ArrayList<>();   //TODO:这里很重要，需要这么写，我才知道数组初始化后，每个项的列表需要单独初始化！
            lists[index].add(a[i]);
        }
        int[] result = new int[a.length];
        int n=0;
        for(int i=0;i<number;i++){
            Collections.sort(lists[i]);
            Iterator it = lists[i].iterator();
            while(it.hasNext()){
                result[n]=(int)it.next();
                n++;
            }
        }
        for(int i=0;i<a.length;i++){
            a[i]=result[i];
        }
    }

    // 基数排序
    public static void baseSort(int[] a){
        int max = a[0];
        for(int i=0;i<a.length;i++){ //求出最大的数
            if (a[i]>max)
                max=a[i];
        }
        int count=0;
        while(max>0){ //要迭代多少次
            max = max /10;
            count++;
        }

        //TODO:对于每轮迭代都有好多东西
        for(int n=0;n<count;n++){
            List<ArrayList> queue = new ArrayList<>();
            for (int i=0;i<10;i++){   //建立相应的队列
                ArrayList sub = new ArrayList();
                queue.add(sub);
            }
            for(int i = 0;i<a.length;i++){
                int num = a[i]% (int) Math.pow(10,n+1)/(int) Math.pow(10,n);
                ArrayList list = queue.get(num);
                list.add(a[i]);
                queue.set(num,list);
            }
            int j=0;
            for(int i=0;i<10;i++){
                if(queue.get(i).size()>0){
                    ArrayList list = queue.get(i);
                    //System.out.println(list);
                    Iterator it = list.iterator();
                    while(it.hasNext()){
                    //    System.out.println(j);
                        a[j]=(int) it.next();
                        j++;

                    }
                }
            }
        }

    }


    public static void swap(int[] a, int i,int j){
        int temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
