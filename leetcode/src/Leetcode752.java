import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Leetcode752 {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>();
        for(String each:deadends) dead.add(each);
        if(dead.contains("0000")) return -1;
        if(target=="0000") return 0;
        Set<String> v = new HashSet<>();  //表示访问过的
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        for(int d=1;!q.isEmpty();d++){ // 一共走了多少步 累加
            for(int n=q.size();n>0;n--){ //对当前这个队列中的数进行操作
                String cur = q.poll(); //取出第一个字符串
                for(int i=0;i<4;i++){ //对于每个数位
                    for(int k=1;k<=9; k=k+8){ //fixme 因为是mod 10 所以表示要么加1要么减1
                        char[] ca = cur.toCharArray();
                        ca[i]=(char) ((ca[i]-'0'+k)%10+'0'); //fixme 如何把char转成数字再转成char
                        String s = new String(ca);
                        if(target.equals(s)) return d;
                        if(!dead.contains(s) && !v.contains(s))
                            q.add(s);
                        v.add(s);
                    }
                }

            }
        }
        return -1;
    }
}
