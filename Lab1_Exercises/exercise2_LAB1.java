import java.util.Scanner;

public class exercise2_LAB1 {
    public static void main(String[] args) {
        int[] arr = new int[3];
        findTheLargestNumber(arr);
    }

    public static void findTheLargestNumber(int arr[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter three integer numbers: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("The max number is: " + max);

    }

}
