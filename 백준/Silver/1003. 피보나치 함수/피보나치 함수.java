import java.util.*;
import java.io.*;
public class Main {
    static int[][] fibo = new int[41][2];
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        fibo[0][0] = 1;
        fibo[0][1] = 0;
        fibo[1][0] = 0;
        fibo[1][1] = 1;
        fibonacci();

        while(a --> 0) {
            int n = sc.nextInt();
            bw.write(fibo[n][0] + " " + fibo[n][1] + "\n");
        }
        bw.flush();
        bw.close();

    }

    static void fibonacci() {
        for(int i=2; i<fibo.length; i++) {
            fibo[i][0] = fibo[i-1][1];
            fibo[i][1] = fibo[i-1][0] + fibo[i-1][1];
        }
    }
}