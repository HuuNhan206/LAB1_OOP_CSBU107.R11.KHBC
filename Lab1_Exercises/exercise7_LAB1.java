import java.util.Scanner;

public class exercise7_LAB1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] first = new int[n];
        for (int i = 0; i < n; i++) {
            first[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] second = new int[m];
        for (int i = 0; i < m; i++) {
            second[i] = sc.nextInt();
        }

        int[] merged = new int[n + m];
        int firstIndex = 0;
        int secondIndex = 0;
        int mergedIndex = 0;

        while (firstIndex < n && secondIndex < m) {
            if (first[firstIndex] <= second[secondIndex]) {
                merged[mergedIndex++] = first[firstIndex++];
            } else {
                merged[mergedIndex++] = second[secondIndex++];
            }
        }

        while (firstIndex < n) {
            merged[mergedIndex++] = first[firstIndex++];
        }

        while (secondIndex < m) {
            merged[mergedIndex++] = second[secondIndex++];
        }

        for (int i = 0; i < merged.length; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(merged[i]);
        }
        System.out.println();
        sc.close();
    }
}
