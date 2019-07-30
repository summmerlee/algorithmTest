import java.util.HashMap;
import java.util.Scanner;

public class duoduo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        if(a==null || a.length()==0){
            System.out.print("false");
            return;
        }

        String[] arr = a.split(" ");
        HashMap<Character,Integer> mapBegin = new HashMap<>();
//        HashMap<Character,Integer> mapEnd = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            char[] c = arr[i].toCharArray();
            if(mapBegin.containsKey(c[0])){
                mapBegin.put(c[0],mapBegin.get(c[0])+1);
            }else{
                mapBegin.put(c[0],1);
            }
            if(mapBegin.containsKey(c[c.length-1])){
                mapBegin.put(c[c.length-1],mapBegin.get(c[c.length-1])+1);
            }else{
                mapBegin.put(c[c.length-1],1);
            }

        }
        boolean flag = true;
        for(Integer each:mapBegin.values()){
            if(each%2!=0){
                flag = false;
                break;
            }
        }
        System.out.print(flag);

    }
}
