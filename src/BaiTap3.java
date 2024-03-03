import java.util.Arrays;
import java.util.Scanner;

public class BaiTap3 {
    public static void main(String[] args) {
        System.out.println("Integer array sorter - To Vinh Tien - 22521474.");
        Scanner scanner = new Scanner(System.in);

        int n = getInputNumberOfElements(scanner);

        int[] numbers = getInputElements(scanner, n);

        sortAndPrintArray(numbers);

        scanner.close();
    }

    public static int getInputNumberOfElements(Scanner scanner) {
        System.out.print("Enter n - the number of elements: ");
        return scanner.nextInt();
    }

    public static int[] getInputElements(Scanner scanner, int n) {
        int[] numbers = new int[n];

        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        return numbers;
    }

    public static void sortAndPrintArray(int[] numbers) {
        Arrays.sort(numbers);

        System.out.print("\nSorted array:");
        for (int num : numbers) {
            System.out.print(" " + num);
        }
        System.out.print(".");
        System.out.println();
    }
}