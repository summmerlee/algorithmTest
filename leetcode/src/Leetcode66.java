public class Leetcode66 {
    // fixme: 这个方法不好，不能满足特别长的数字
    public static int[] plusOne(int[] digits) {
        long number = 0L;
        int len = digits.length;
        for(int i=0;i<len;i++){
            number = number+ (long) digits[i]*((int) Math.pow(10,len-1-i));
        }
        System.out.println(number);
        number = number +1;
        long temp = number;
        int count = 0;
        while(temp>0){
            temp = temp/10;
            count++;
        }
        int[] res = new int[count];
       System.out.println("count"+count+"number"+number);
        for(int i=0;i<count;i++){
            res[i] = (int) (number/(long) Math.pow(10,count-1-i));
            number = number% ((int) Math.pow(10,count-1-i));
           // System.out.println(res[i]+" "+number);
        }
        return res;
    }


    /**
     * 首先判断最后一位是否为9，若不是，直接加一返回，若是，则该位赋0，再继续查前一位，同样的方法，知道查完第一位。
     * 如果第一位原本为9，加一后会产生新的一位，那么最后要做的是，查运算完的第一位是否为0，如果是，则在最前头加一个1
     */
    public static int[] plusOne1(int[] digits) {
        if (digits.length==0)
            return digits;

        for (int i = digits.length -1; i>=0;i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] res = new int[digits.length+1];
        res[0] = 1;
        return res;
    }

    public static void main(String[] args){
        int[] nums1={1,9};
        int[] answer = plusOne1(nums1);
        for (int each:answer) {
            System.out.print(each+" ");
        }
    }
}
