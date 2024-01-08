import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[] f1 = new int[6];
        int[] f2 = new int[6];
        Integer x = null;
        Integer y = null;
        for (int i = 0; i < 6; i++) {
            f1[i] = sc.nextInt();
        }
        for (int j = 0; j < 6; j++) {
            if(j < 3) {
                f2[j] = f1[j] * f1[4];
            } else {
                f2[j] = f1[j] * f1[1];
            }
        }
        for(int k=-999; k<=999; k++) {
            if((f2[0] - f2[3]) * k == f2[2] - f2[5]) {
                x = k;
                break;
            }
        }
        if (f1[1] != 0) {
            y = (f1[2] - f1[0] * x) / f1[1];
        } else {
            y = (f1[5] - f1[3] * x) / f1[4];
        }
        System.out.println(x + " " + y);
    }
}