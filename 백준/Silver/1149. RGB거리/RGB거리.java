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
            color(i, 0);
            color(i, 1);
            color(i, 2);
        }
        int answer = Math.min(dp[len - 1][0], Math.min(dp[len - 1][1], dp[len - 1][2]));
        System.out.println(answer);
    }

    static int color(int row, int col) {
        if (dp[row][col] == 0) {
            if (col == 0) {
                dp[row][col] = houses[row][col] + Math.min(color(row - 1, 1), color(row - 1, 2));
            } else if (col == 1) {
                dp[row][col] = houses[row][col] + Math.min(color(row - 1, 0), color(row - 1, 2));
            } else {
                dp[row][col] = houses[row][col] + Math.min(color(row - 1, 0), color(row - 1, 1));
            }
        }
        return dp[row][col];
    }
}