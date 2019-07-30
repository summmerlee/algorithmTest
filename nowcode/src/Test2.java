import java.util.Scanner;


/**
 * shopee第二题
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] p = new int[n+1];
        long[][] dp = new long[n+1][m+1];
        for(int i=1; i<=n; i++){
            p[i] = sc.nextInt();
        }
        for(int i=0; i<=n; i++){
            dp[i][0] = 1;
        }
        for(int j=1; j<=m; j++){
            dp[0][j] = 0;
        }
        for(int i=1; i<=n; i++){
            for(int j=0; j<=m; j++){
                if(p[i] <= j){
                    dp[i][j] = dp[i-1][j] +dp[i-1][j-p[i]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
