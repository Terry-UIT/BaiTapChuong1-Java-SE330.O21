import java.util.Scanner;

public class BaiTap4 {
    public static void main(String[] args){
        System.out.println("Days of month counter - To Vinh Tien - 22521474.");
        Scanner scanner = new Scanner(System.in);

        int month = getMonth(scanner);
        int year = getYear(scanner);

        String monthName = getMonthName(month);

        int daysInMonth = calculateDaysInMonth(month, year);

        System.out.println("\nThere are " + daysInMonth + " days in " + monthName + " - " + year + ".");

        scanner.close();
    }
    public static int getMonth(Scanner scanner){
        int month;
        do{
            System.out.print("Enter the month (1-12): ");
            month = scanner.nextInt();
            if(month < 1 || month > 12){
                System.out.print("Invalid month number. Please enter a number between 1 and 12.");
            }
        } while(month < 1 || month > 12);
        return month;
    }

    public static int getYear(Scanner scanner){
        System.out.print("Enter the year: ");
        return scanner.nextInt();
    }

    public static int calculateDaysInMonth(int month, int year){
        switch (month){
            case 1, 3, 5, 7, 8, 10, 12:
                return 31;
            case 4, 6, 9, 11:
                return 30;
            case 2:
                if(isLeapYear(year)){
                    return 29;
                } else {
                    return 28;
                }
            default:
                return -1; // Return -1 if the inputted month is invalid.
        }
    }

    public static boolean isLeapYear(int year){
        return (year % 4 == 0 && year % 100 !=0) || (year % 400 == 0);
    }

    public static String getMonthName(int month){
        return switch (month) {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> null;
        };
    }}