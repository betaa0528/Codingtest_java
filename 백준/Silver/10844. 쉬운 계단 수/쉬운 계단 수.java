import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int mod = 1000000000;
        long[][] arr = new long[101][10];
        for (int i = 0; i < 10; i++) {
            arr[1][i] = 1;
        }

        for (int j = 2; j < arr.length; j++) {
            for (int k = 0; k < arr[j].length; k++) {
                if (k - 1 > -1 && k + 1 < 10) {
                    arr[j][k] = (arr[j-1][k - 1] + arr[j - 1][k + 1]) % mod;
                } else if (k == 0) {
                    arr[j][k] = (arr[j - 1][k + 1]) % mod;
                } else if (k == 9) {
                    arr[j][k] = (arr[j - 1][k - 1]) % mod;
                }
            }
        }
        long answer = 0;
        for(int l=1; l<10; l++) {
            answer += arr[N][l];
        }

        System.out.println(answer%mod);
    }
}