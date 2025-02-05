
import java.util.Scanner;

public class Main {
    public static int answer;
    public static int start;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        start = 4;
        answer = 0;
        for(int i=2019; i<=year; i++) {
            friCheck(i, start);
        }
        System.out.println(answer);
    }

    public static void friCheck(int year, int startDay) {
        boolean leap = checkLeap(year);
        int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int fri = startDay % month[0];
        month[1] = leap ? 29 : 28;
        for (int i = 0; i < month.length; i++) {
            while (fri <= month[i]) {
                fri = fri + 7;
                if (fri > month[i]) {
                    fri -= month[i];
                    break;
                }
                if (fri == 13) {
                    answer++;
                }
            }
        }
        start = fri;
    }

    public static boolean checkLeap(int year) {
        if (year % 400 == 0) {
            return true;
        }

        if (year % 400 != 0 && year % 100 == 0) {
            return false;
        }

        if (year % 100 != 0 && year % 4 == 0) {
            return true;
        }

        return false;
    }
}