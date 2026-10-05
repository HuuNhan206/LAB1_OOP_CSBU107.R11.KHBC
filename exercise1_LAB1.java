import java.util.Scanner;

public class exercise1_LAB1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println("Enter an integer number: " + n);

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                System.out.println(i + "Even");
            } else {
                System.out.println(i + "Odd");

            }
        }

        sc.close();
    }
}