import java.util.*;
import java.io.*;

public class Main {
    static int[][] dp;
    static int[][] houses;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        houses = new int[T][3];
        dp = new int[T][3];
        int len = houses.length;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreElements()) {
                houses[len - T - 1][0] = Integer.parseInt(st.nextToken());
                houses[len - T - 1][1] = Integer.parseInt(st.nextToken());
                houses[len - T - 1][2] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = houses[0][0];
        dp[0][1] = houses[0][1];
        dp[0][2] = houses[0][2];
        for (int i = 1; i < len; i++) {
            dp[i][0] = houses[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = houses[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = houses[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }
        int answer = Math.min(dp[len - 1][0], Math.min(dp[len - 1][1], dp[len - 1][2]));
        System.out.println(answer);
    }

   
}