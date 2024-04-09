import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] time = new int[N];
        int[] cost = new int[N];
        int[] dp = new int[N + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            cost[i] = Integer.parseInt(st.nextToken());
        }
        for(int j=0; j<N; j++) {
            if(j + time[j] <= N) {
                dp[j+time[j]] = Math.max(cost[j] + dp[j], dp[j+time[j]]);
            }
            dp[j+1] = Math.max(dp[j+1], dp[j]);
        }
        System.out.println(dp[N]);
    }}