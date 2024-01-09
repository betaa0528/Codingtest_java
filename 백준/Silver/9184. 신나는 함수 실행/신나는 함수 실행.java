import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Integer[][][] dp = new Integer[21][21][21];
        dp[0][0][0] = 1;
        int a, b, c, answer;

        while (true) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1 && c == -1) break;

            answer = solution(a, b, c, dp);
            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + answer);
        }
    }

    private static int solution(int a, int b, int c, Integer[][][] dp) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return dp[0][0][0];
        }  else if (a > 20 || b > 20 || c > 20) {
            return solution(20, 20, 20, dp);
        } else if (dp[a][b][c] != null) {
            return dp[a][b][c];
        } else if (a < b && b < c) {
            return dp[a][b][c] = solution(a, b, c - 1, dp) + solution(a, b - 1, c - 1, dp) - solution(a, b - 1, c, dp);
        } else {
            return dp[a][b][c] = solution(a - 1, b, c, dp)
                    + solution(a - 1, b - 1, c, dp)
                    + solution(a - 1, b, c - 1, dp)
                    - solution(a - 1, b - 1, c - 1, dp);
        }
    }
}