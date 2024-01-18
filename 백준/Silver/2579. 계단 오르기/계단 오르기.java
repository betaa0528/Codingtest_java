import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] stair = new int[N+1];
        int[] dp = new int[N + 1];
        for (int i = 1; i < N+1; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 0;
        dp[1] = stair[1];
        if(N > 1){
            dp[2] = stair[1] + stair[2];        
        }
        if(N > 2) {
            for (int j = 3; j <= N; j++) {
            dp[j] = Math.max(dp[j-3]+stair[j-1] , dp[j-2]) + stair[j];
            }
        }
        System.out.println(dp[N]);
    }
}