public class Leetcode67 {
    // fixme.这里要学的一个是char的加减结果是ascii码的运算 返回的是Integer
    //  以及StringBuffer的insert
    public String addBinary(String a, String b) {
        int len = Math.max(a.length(),b.length());
        int carry = 0;
        StringBuffer sb = new StringBuffer();
        for(int n =0;n<len;n++){ //开始逐位取出a和b每一位的值，空的话用0代替
            int tempA = a.length()>n ? a.charAt(a.length()-1-n)-'0' : 0;
            int tempB = b.length()>n ? b.charAt(b.length()-1-n)-'0' : 0;
            sb.insert(0,(tempA+tempB+carry)%2);
            carry = tempA+tempB+carry>1? 1:0;
        }
        if(carry==1)
            sb.insert(0,1);
        return sb.toString();
    }
}
