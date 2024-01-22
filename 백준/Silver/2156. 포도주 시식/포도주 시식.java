import java.util.*;
import java.io.*;
public class Main {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] wines = new int[N];
        dp = new int[N+1];
        for(int i=0; i<N; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }
        if (N == 1) {
            System.out.println(wines[0]);
        } else {
            dp[0] = 0;
            dp[1] = wines[0];
            dp[2] = wines[0] + wines[1];
            for (int j = 3; j < dp.length; j++) {
                dp[j] = Math.max(dp[j - 1], Math.max(dp[j - 2], dp[j - 3] + wines[j - 2]) + wines[j - 1]);
            }

            System.out.println(dp[N]);
        }

    }

}