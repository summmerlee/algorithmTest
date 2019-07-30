import java.util.Scanner;

public class duoduo1 {
    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String a = in.nextLine();
            String b = in.nextLine();
            String[] as = a.split(" ");
            String[] bs = b.split(" ");
            int[] A = new int[as.length];
            int[] B = new int[bs.length];
            int theNumA = Integer.valueOf(as[0]); //记录那个数字
            A[0] = theNumA;
            int index = 0;
            int before = 0, after = 0; //前后两个数字
            for(int i=1;i<A.length;i++){
                A[i] = Integer.valueOf(as[i]);
            }
            for(int i=1;i<A.length;i++){
                if(A[i]<=A[i-1]) {
                    index = i;
                    theNumA = A[i];
                    before = A[i-1];
                    after = A[i+1];
                }
            }
            int res=-1; //替换的最大数
            for(int j=0;j<B.length;j++){
                B[j] = Integer.valueOf(bs[j]);
                if(B[j]<after && B[j]>before && B[j]>res){
                    res = B[j];
                }
            }
            if(res==-1) System.out.print("No");
            else {
                A[index] = res;
                StringBuffer sb = new StringBuffer();
                for (int n = 0; n < A.length; n++) {
                    sb.append(A[n]).append(" ");
                }
                System.out.print(sb.toString());
            }

    }
}
// 55%

