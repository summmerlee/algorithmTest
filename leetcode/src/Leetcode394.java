import java.util.Stack;

public class Leetcode394 {

    // fixme: 这个题目把我搞死了 原因是java基本类型都是值传递（拷贝了副本）所以我用了对象草
    private static class Value{
        int i=0;
    }
    public static String decodeString(String s) {
        Value u = new Value();
        return decode(s,u);
    }

    private static String decode(String s, Value value){
        char[] ch = s.toCharArray();
        String res = "";
        while(value.i<ch.length && ch[value.i]!=']'){
            if(!Character.isDigit(ch[value.i])){
                res=res+ch[value.i];
                value.i++;
            }else{
                int count = 0;
                while(Character.isDigit(ch[value.i])){
                    count = count*10+ch[value.i]-'0'; //这里需要-'0'
                    value.i++;
                }
                value.i++; //这里是用来跳过'['的
                String temp = decode(s,value); // ']'之前也就是需要循环的内容
                while(count>0){
                    res=res+temp;
                    count--;
                }
                value.i++; //跳过']'

            }

        }
        return res;
    }
    public static void main(String[] args){
        String s = "3[a]2[bc]";
        System.out.print(decodeString(s));

    }

    // fixme 方法二
    /**
     * 1.使用两个栈，countStack存子串的重复次数，resStack存中间结果
     *   2.读取完一个数字，把数量入countStack栈
     *   3.读取到[时，把n[前面的结果计算出来并入resStack栈
     *   4.读取到]时，取出最近一次n[res]前面的中间计算结果，也就是resStack的栈顶，再append n次res，n为countStack的栈顶，res为最近一次[]中间的子串
     *   5.其他情况，将字符追加到res末尾
     *
     *   比如:  3[a]2[b3[d]c]
     *  下面是读完各字符时的情况：
     *  *        读完:  3    [     a     ]     2    [    b      3       [      d       ]      c       ]
     *  * countStack: (3)  (3)   (3)    ()   (2)  (2)  (2)   (2 3)   (2 3)   (2 3)   (2)    (2)      ()
     *  *   resStack: ()   ("")  ("")   ()   ()  (aaa) (aaa) (aaa)  (aaa b) (aaa b)  (aaa) (aaa)     ()
     *  *        res: ""    ""    a     aaa  aaa   ""   b      b       ""     d      bddd  bdddc  aaabdddcbdddc
     */
    public String decodeString1(String s) {
        Stack<Integer> intStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder cur = new StringBuilder();
        int k = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if (ch == '[') {
                intStack.push(k);
                strStack.push(cur);
                cur = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder tmp = cur;
                cur = strStack.pop();
                for (k = intStack.pop(); k > 0; --k) cur.append(tmp);
            } else cur.append(ch);
        }
        return cur.toString();
    }
}
