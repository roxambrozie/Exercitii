package exercitii;

import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please add a number to retrieve the corresponding month:");

        int monthNumber = in.nextInt();

        System.out.println("Please add a year: ");
        int year = in.nextInt();

        System.out.println(isLeapYear(year));

        if (isLeapYear(year) && monthNumber == 2) {
            System.out.println("February has 29 days.");
        } else {
            System.out.println(getNumberOfDaysInMonth(monthNumber));
        }
    }

    public static String getNumberOfDaysInMonth(int number) {
        String month = "";
        switch (number) {
            case 1:
                month = "January has 31 days.";
                break;
            case 2:
                month = "February has 28 days.";
                break;
            case 3:
                month = "March has 31 days.";
                break;
            case 4:
                month = "April has 30 days.";
                break;
            case 5:
                month = "May has 31 days.";
                break;
            case 6:
                month = "June has 30 days.";
                break;
            case 7:
                month = "July has 31 days.";
                break;
            case 8:
                month = "August has 31 day";
                break;
            case 9:
                month = "September has 30 days";
                break;
            case 10:
                month = "October has 31 days.";
                break;
            case 11:
                month = "November has 30 days.";
                break;
            case 12:
                month = "December has 31 days.";
                break;

            default:
                month = "Invalid month range";
        }

        return month;
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return true;
        }
    }
}
