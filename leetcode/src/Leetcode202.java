import java.util.HashSet;

public class Leetcode202 {
    public static boolean isHappy(int n) {
        int sum = n,m = n;
        boolean flag = false;
        HashSet<Integer> hs = new HashSet<>();
        while(sum!=1){
            m = sum;
            int temp =sum;
            int size=1;
            while(m/10>0){
                size++;
                m = m/10;
            }
            int[] dig = new int[size];
            int i=0;
            sum = 0;
            while(i<size){
                dig[i] =(temp% (int) Math.pow(10,i+1))/(int)Math.pow(10,i);
                sum =sum+dig[i]*dig[i];
                i++;
            }
            if(hs.contains(sum)){
                flag = false;
                break;
            }else if(sum==1){
                flag = true;
                break;
            }else
                hs.add(sum);
        }
        if(n==1) return true;
        return flag;
    }

    public static void main(String[] args){
        int test = 19;
        isHappy(test);

    }
}
