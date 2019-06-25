public class Main {
    public static void main(String[] args) {
       String a = "a good   example";
       String[] b = a.split(" ");
       System.out.println(b.length);
       for(String each:b){
           System.out.println(each+"a");
       }

    }
}