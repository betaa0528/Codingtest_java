import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] square = new long[1001];
        square[1] = 1;
        square[2] = 2;
        for(int i=3; i<1001; i++) {
            square[i] = (square[i-1] + square[i-2]) % 10007;
        }
        System.out.println(square[n]);
    }
}