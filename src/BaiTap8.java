import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Arrays;

public class BaiTap8 {
    public static void main(String[] args) {
        System.out.println("Integer array manager - To Vinh Tien - 22521474.");
        Scanner scanner = new Scanner(System.in);

        int[] array = inputArray(scanner);
        if (array == null) {
            System.out.println("\nInvalid input for array. Exiting program...");
            return;
        }

        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Count even and odd elements.");
            System.out.println("2. Calculate average.");
            System.out.println("3. Find max and min elements.");
            System.out.println("4. Reverse array.");
            System.out.println("5. Sort array.");
            System.out.println("6. Exit.");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            System.out.println();
            switch (choice) {
                case 1:
                    countEvenAndOddElements(array);
                    waitForEnter(scanner);
                    break;
                case 2:
                    calculateAverage(array);
                    waitForEnter(scanner);
                    break;
                case 3:
                    findMaxAndMin(array);
                    waitForEnter(scanner);
                    break;
                case 4:
                    reverseArray(array);
                    waitForEnter(scanner);
                    break;
                case 5:
                    sortArray(array);
                    waitForEnter(scanner);
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option! Please choose again.");
                    break;
            }
        }

        scanner.close();
    }

    public static int[] inputArray(Scanner scanner) {
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        if (n <= 0) {
            return null;
        }

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the " + getOrdinal(i + 1) + " element: ");
            array[i] = scanner.nextInt();
        }
        scanner.nextLine();

        return array;
    }

    public static void countEvenAndOddElements(int[] array) {
        int evenCount = 0;
        int oddCount = 0;

        for (int num : array) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("Number of even elements: " + evenCount + ".");
        System.out.println("Number of odd elements: " + oddCount + ".");
    }

    public static void calculateAverage(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        double average = (double) sum / array.length;

        DecimalFormat df = new DecimalFormat("#.####");
        System.out.println("Average of the array: " + df.format(average) + ".");
    }

    public static void findMaxAndMin(int[] array) {
        int max = array[0];
        int min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }

        System.out.println("Max element: " + max + ".");
        System.out.println("Min element: " + min + ".");
    }

    public static void reverseArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }

        System.out.print("Reversed array:");
        printArray(array);
        System.out.println(".");
    }

    public static void sortArray(int[] array) {
        Arrays.sort(array);

        System.out.print("Sorted array:");
        printArray(array);
        System.out.println(".");
    }

    public static void waitForEnter(Scanner scanner) {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    public static String getOrdinal(int number) {
        int remainder10 = number % 10;
        int remainder100 = number % 100;
        if (remainder10 == 1 && remainder100 != 11) {
            return number + "st";
        } else if (remainder10 == 2 && remainder100 != 12) {
            return number + "nd";
        } else if (remainder10 == 3 && remainder100 != 13) {
            return number + "rd";
        } else {
            return number + "th";
        }
    }

    public static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(" " + element);
        }
    }
}