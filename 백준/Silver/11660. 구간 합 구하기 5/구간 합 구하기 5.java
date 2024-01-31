import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] table = new int[N+1][N+1];
        int[][] dp = new int[N+1][N+1];
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
                if (i == 1 && j == 1) {
                    dp[i][j] = table[i][j];
                } else if (j == 1) {
                    dp[i][j] = table[i][j] + dp[i - 1][j];
                } else if (i == 1) {
                    dp[i][j] = table[i][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = table[i][j] + dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1];
                }
            }
        }
        while(M --> 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            if(x1 == x2 && y1==y2) {
                System.out.println(table[x1][y1]);
            } else {
                System.out.println(dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1]);
            }
        }
    }
}