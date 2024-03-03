import java.util.Scanner;

public class BaiTap6 {
    public static void main(String[] args) {
        System.out.println("Calendar - To Vinh Tien - 22521474.");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter year: ");
        int year = scanner.nextInt();

        displayCalendar(year);

        scanner.close();
    }

    public static void displayCalendar(int year) {
        for (int month = 1; month <= 12; month++) {
            System.out.println("\n\n" + getMonthName(month) + " - " + year);
            System.out.println("Mon  Tue  Wed  Thu  Fri  Sat  Sun");

            int startDayOfMonth = getStartDayOfMonth(year, month);
            int daysInMonth = getDaysInMonth(year, month);

            for (int i = 0; i < startDayOfMonth; i++) {
                System.out.print("     ");
            }

            for (int day = 1; day <= daysInMonth; day++) {
                System.out.printf("%-5d", day);
                startDayOfMonth++;

                if (startDayOfMonth % 7 == 0) {
                    System.out.println();
                }
            }
        }
    }

    public static int getStartDayOfMonth(int year, int month) {
        final int START_DAY_FOR_JAN_1_1800 = 2;
        int totalDays = getTotalDays(year, month);
        return (totalDays + START_DAY_FOR_JAN_1_1800) % 7;
    }

    public static int getTotalDays(int year, int month) {
        int total = 0;
        for (int i = 1800; i < year; i++) {
            for (int j = 1; j <= 12; j++) {
                total += getDaysInMonth(i, j);
            }
        }
        for (int i = 1; i < month; i++) {
            total += getDaysInMonth(year, i);
        }
        return total;
    }

    public static int getDaysInMonth(int year, int month) {
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else if (month == 2) {
            return isLeapYear(year) ? 29 : 28;
        } else {
            return 31;
        }
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static String getMonthName(int month) {
        String[] monthNames = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        return monthNames[month - 1];
    }
}