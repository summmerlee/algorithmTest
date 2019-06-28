public class Leetcode279 {
    // fixme 这道题考察的是"四平方和定理"：每个正整数均可表示为4个整数的平方和
    //  如果一个数有因子4，那么去掉4因子之后并不影响其平方和性质。如果一个数除余8等于7，那么其是由4个数平方构成 4^k(8m+
    public int numSquares(int n) {
        while(n%4==0) n = n/4;
        if(n%8==7) return 4;
        int a =0;
        while(a*a<=n){
            int b = (int) Math.sqrt(n-a*a);
            if(n==(a*a+b*b)){
                if(a!=0 && b!=0)
                    return 2;
                else
                    return 1;
            }
            a++;
        }
        return 3;
    }
}
