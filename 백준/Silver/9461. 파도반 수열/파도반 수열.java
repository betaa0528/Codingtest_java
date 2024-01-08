import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N;
        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        while(T --> 0) {
            N = Integer.parseInt(br.readLine());
            if(N > 3 && dp[N] == 0) {
                for(int i=4; i<=N; i++) {
                    dp[i] = dp[i-2] + dp[i-3];
                }
            }
            System.out.println(dp[N]);
        }
    }
}