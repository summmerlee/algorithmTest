import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("100");
        BigDecimal b = new BigDecimal("10");
        a=a.subtract(b);
        System.out.print(a.toString());

    }
}