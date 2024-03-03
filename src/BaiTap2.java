import java.util.Scanner;

public class BaiTap2 {
    public static void main(String[] args) {
        System.out.println("Quadratic Equation ax^2 + bx + c = 0 solver - To Vinh Tien - 22521474.");
        Scanner scanner = new Scanner(System.in);
        System.out.println();

        double a = getInputCoefficient(scanner, 'a');
        double b = getInputCoefficient(scanner, 'b');
        double c = getInputCoefficient(scanner, 'c');

        double delta = calculateDelta(a, b, c);

        printRoots(a, b, delta);

        scanner.close();
    }

    public static double getInputCoefficient(Scanner scanner, char coefficientName) {
        double coefficient = 0;
        while (coefficient == 0) {
            System.out.print("Enter coefficient " + coefficientName + ": ");
            coefficient = scanner.nextDouble();

            if (coefficient == 0) {
                System.out.println("Coefficient " + coefficientName + " must be non-zero. Please enter again.");
            }
        }
        return coefficient;
    }

    public static double calculateDelta(double a, double b, double c) {
        return b * b - 4 * a * c;
    }

    public static void printRoots(double a, double b, double delta) {
        System.out.println();
        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.print("The equation has two distinct real roots: ");
            System.out.print("x1 = " + x1);
            System.out.print(" ;x2 = " + x2 + ".");
        } else if (delta == 0) {
            double x = -b / (2 * a);
            System.out.print("The equation has a double root: ");
            System.out.print("x = " + x + ".");
        } else {
            System.out.print("The equation has no real roots.");
        }
        System.out.println();
    }
}