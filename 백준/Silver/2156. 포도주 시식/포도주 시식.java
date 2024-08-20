import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        int[] wines = new int[n+1];
        int[] dp = new int[n+1];
        for(int i=0; i<n; i++) {
            wines[i+1] = Integer.parseInt(br.readLine());
        }
        dp[0] = 0;
        if(n == 1) {
            System.out.println(wines[1]);
            return ;
        }
        dp[1] = wines[1];
        dp[2] = wines[1] + wines[2];
        for(int i=3; i<=n; i++) {
            dp[i] = Math.max(Math.max(dp[i-2],  wines[i-1] + dp[i-3]) + wines[i], dp[i-1]) ;
        }
        System.out.println(dp[n]);
    }
}