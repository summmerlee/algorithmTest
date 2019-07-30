import java.util.Scanner;

/**
 * shopee第一题
 */

public class Test {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String temp = sc.nextLine();
        String[] strings = temp.split(" ");
        String str1 = strings[0];
        String str2 = strings[1];
        if(str1.length() < str2.length()){
            String tem = str1;
            str1 = str2;
            str2 = tem;
        }
        if(!str1.contains(str2)){
            System.out.print("");
        }
        int len1 = str1.length();
        int len2 = str2.length();
        int index = len2;
        while (index >= 1) {
            if(len1 % index == 0 && len2 % index == 0){
                String tem = str2.substring(0,index);
                StringBuffer sb1 = new StringBuffer(tem);
                while (sb1.length() != str1.length()) {
                    sb1.append(tem);
                }
                StringBuffer sb2 = new StringBuffer(tem);
                while (sb2.length() != str2.length()) {
                    sb2.append(tem);
                }
                if(new String(sb1).equals(str1) && new String(sb2).equals(str2)){
                    System.out.print(tem);
                }
            }
            index --;
        }
        System.out.print("");

    }

}