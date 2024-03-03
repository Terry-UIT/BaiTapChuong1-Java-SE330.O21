import java.util.Scanner;

public class BaiTap7 {
    private static class Fraction {
        int numerator;
        int denominator;

        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        public double getValue() {
            return (double) numerator / denominator;
        }
    }

    public static void main(String[] args) {
        System.out.println("Min/Max fraction in array - To Vinh Tien - 22521474.");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter n - the number of fractions:    ");
        int n = scanner.nextInt();

        Fraction[] fractions = new Fraction[n];

        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter " + getOrdinal(i + 1) + " fraction's numerator:       ");
            int numerator = scanner.nextInt();
            System.out.print("Enter " + getOrdinal(i + 1) + " fraction's denominator:     ");
            int denominator = scanner.nextInt();
            fractions[i] = new Fraction(numerator, denominator);
        }

        Fraction minFraction = findMinFraction(fractions);
        Fraction maxFraction = findMaxFraction(fractions);

        System.out.println("\nSmallest fraction: " + minFraction.numerator + "/" + minFraction.denominator + ".");
        System.out.println("Largest fraction: " + maxFraction.numerator + "/" + maxFraction.denominator+ ".");

        scanner.close();
    }

    private static Fraction findMinFraction(Fraction[] fractions) {
        Fraction minFraction = fractions[0];
        for (int i = 1; i < fractions.length; i++) {
            if (fractions[i].getValue() < minFraction.getValue()) {
                minFraction = fractions[i];
            }
        }
        return minFraction;
    }

    private static Fraction findMaxFraction(Fraction[] fractions) {
        Fraction maxFraction = fractions[0];
        for (int i = 1; i < fractions.length; i++) {
            if (fractions[i].getValue() > maxFraction.getValue()) {
                maxFraction = fractions[i];
            }
        }
        return maxFraction;
    }
    private static String getOrdinal(int number) {
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
}