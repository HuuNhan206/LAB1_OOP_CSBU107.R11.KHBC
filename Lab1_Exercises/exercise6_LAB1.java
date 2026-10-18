import java.util.Scanner;

public class exercise6_LAB1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int arr[] = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }

        int x = sc.nextInt();
        int index = -1;

        for (int i = 0; i < num; i++) {
            if (arr[i] == x) {
                index = i;
                break;
            }
        }

        System.out.println(index);
        sc.close();
    }
}
