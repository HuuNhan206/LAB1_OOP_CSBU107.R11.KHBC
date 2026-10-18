import java.util.Scanner;

public class exercise4_LAB1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = sc.nextLine();

        String reversedStr = "";
        for (int i = str.length(); i > 0; i--) {
            reversedStr += str.charAt(i - 1);

        }
        System.out.println("Reversed string: " + reversedStr);

    }
}