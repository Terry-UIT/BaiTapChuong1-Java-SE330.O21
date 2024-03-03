import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class BaiTap5 {
    private static int size;

    public static void main(String[] args) {
        System.out.println("Integer array manager - To Vinh Tien - 22521474.");
        Scanner scanner = new Scanner(System.in);

        int[] array = inputArray(scanner);
        if (array == null) {
            System.out.println("\nInvalid input for array. Exiting program...");
            return;
        }
        menu(scanner, array);

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

        size = n;

        return array;
    }

    public static void printArray(Scanner scanner, int[] array) {
        for (int element: array) {
            System.out.print(" " + element);
        }
        System.out.print(".");
        System.out.println();
        System.out.print("\nPress Enter to return to the menu...");
        scanner.nextLine();
    }

    public static void addElement(Scanner scanner, int[] array) {
        if (size < array.length) {
            System.out.print("Enter the element to add: ");
            int element = scanner.nextInt();
            array[size++] = element;
            System.out.println("\nElement " + element + " has been added to the list.");
        } else {
            System.out.println("The array is full. Cannot add more elements.");
        }
        System.out.print("\nPress Enter to return to the menu...");
        scanner.nextLine();
        scanner.nextLine();
    }

    public static void deleteElement(Scanner scanner, int[] array) {
        System.out.print("Enter the index of the element to delete (1 - " + size + "): ");
        int index = scanner.nextInt();
        if (index >= 1 && index <= size) {
            int deleteElement = array[index - 1];
            for (int i = index - 1; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            size--;
            System.out.println("\nThe element at index " + index + " (number " + deleteElement +
                    ") has been deleted from the array.");
        } else {
            System.out.println("\nInvalid index.");
        }
        System.out.print("\nPress Enter to return to the menu...");
        scanner.nextLine();
        scanner.nextLine();
    }

    public static void editElement(Scanner scanner, int[] array) {
        System.out.print("Enter the index of the element to edit (1 - " + size + "): ");
        int index = scanner.nextInt();
        if (index >= 1 && index <= size) {
            System.out.print("Enter the new value: ");
            int oldElement = array[index - 1];
            int newElement = scanner.nextInt();
            array[index - 1] = newElement;
            System.out.println("\nThe element at index " + index + " (number " + oldElement + ") has been updated to " +
                    newElement + ".");
        } else {
            System.out.println("\nInvalid index.");
        }
        System.out.print("\nPress Enter to return to the menu...");
        scanner.nextLine();
        scanner.nextLine();
    }

    public static void sortElement(int[] array) {
        Arrays.sort(array, 0, size);
        System.out.println("The inputted array has been sorted in ascending order.");
        System.out.println();
    }

    public static void calculateAverage(Scanner scanner, int[] array) {
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += array[i];
        }
        double average = sum / size;
        DecimalFormat df = new DecimalFormat("#.####");
        String formattedAverage = df.format(average);
        System.out.println("Average of the array: " + formattedAverage + ".");
        System.out.print("\nPress Enter to return to the menu...");
        scanner.nextLine();
    }

    public static void nearestToAverage(Scanner scanner, int[] array) {
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += array[i];
        }
        double average = sum / size;

        int nearestElement = array[0];
        int nearestIndex = 0;
        double minDifference = Math.abs(array[0] - average);
        for (int i = 0; i < size; i++) {
            double difference = Math.abs(array[i] - average);
            if (difference < minDifference) {
                minDifference = difference;
                nearestElement = array[i];
                nearestIndex = i;
            }
        }
        DecimalFormat df = new DecimalFormat("#.####");
        String formattedAverage = df.format(average);
        System.out.println("Element nearest to the average (" + formattedAverage + "): " + nearestElement +
                " (with index " + (nearestIndex + 1) + ").");
        System.out.print("\nPress Enter to return to the menu...");
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

    public static void menu(Scanner scanner, int[] array) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Print array.");
            System.out.println("2. Add an element.");
            System.out.println("3. Delete an element");
            System.out.println("4. Edit an element");
            System.out.println("5. Sort array");
            System.out.println("6. Calculate average");
            System.out.println("7. Find number nearest to the average element");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            switch (choice) {
                case 1:
                    System.out.print("The inputted array:");
                    printArray(scanner, array);
                    break;
                case 2:
                    addElement(scanner, array);
                    break;
                case 3:
                    deleteElement(scanner, array);
                    break;
                case 4:
                    editElement(scanner, array);
                    break;
                case 5:
                    sortElement(array);
                    System.out.print("Sorted array:");
                    printArray(scanner, array);
                    break;
                case 6:
                    calculateAverage(scanner, array);
                    break;
                case 7:
                    nearestToAverage(scanner, array);
                    break;
                case 8:
                    exit = true;
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 8.");
            }
        }
    }
}
