package Exception2;
import java.util.Scanner;

public class Exception2 {
    public static void exceptionDemo() {
        Scanner sc = new Scanner(System.in);
        String intString = sc.next();
        try {
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        }catch (ArithmeticException | NumberFormatException e) {
            System.out.println("Arithmetic Error");
        }
    }

    public static void main(String[] args) {
        exceptionDemo();
    }
}

