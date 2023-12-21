import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String[]> list = new ArrayList<>();
        int line = 20;
        int creditSum = 0;
        double grade = 0;
        while(line --> 0) {
            list.add(br.readLine().split(" "));
        }
        int credit = 0;

        for(String[] arr : list) {
            credit = (int) Double.parseDouble(arr[1]);
            switch (arr[2]) {
                case "A+" :
                    grade += credit * 4.5;
                    creditSum += credit;
                    break;
                case "A0" :
                    grade += credit * 4.0;
                    creditSum += credit;
                    break;
                case "B+" :
                    grade += credit * 3.5;
                    creditSum += credit;
                    break;
                case "B0" :
                    grade += credit * 3.0;
                    creditSum += credit;
                    break;
                case "C+" :
                    grade += credit * 2.5;
                    creditSum += credit;
                    break;
                case "C0" :
                    grade += credit * 2.0;
                    creditSum += credit;
                    break;
                case "D+" :
                    grade += credit * 1.5;
                    creditSum += credit;
                    break;
                case "D0" :
                    grade += credit * 1.0;
                    creditSum += credit;
                    break;
                case "F" :
                    grade += credit * 0.0;
                    creditSum += credit;
                    break;
                default:
                    break;
            }
        }
        System.out.println(grade/creditSum);
    }
}