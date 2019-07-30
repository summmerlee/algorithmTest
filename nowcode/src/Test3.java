import java.util.HashSet;
import java.util.Scanner;

/**
 * shopee第三题
 */

public class Test3 {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String aa = sc.nextLine();
        String[] as = aa.split(" ");
        int[] temp = new int[as.length];
        for(int i=0;i<temp.length;i++){
            temp[i] = Integer.valueOf(as[i]);
        }
        ListNode head = new ListNode(temp[0]);
        ListNode a = head;
        for(int i=1;i<temp.length;i++){
            ListNode now = new ListNode(temp[i]);
            a.next = now;
            a = now;
        }
        HashSet<Integer> set = new HashSet<>();
        StringBuffer sb = new StringBuffer();
        ListNode b = head;
        while(b!=null){
            if(set.contains(b.val))
                b=b.next;
            else {
                sb.append(b.val);
                set.add(b.val);
                b = b.next;
            }
        }
        System.out.print(sb.toString());

    }
}
