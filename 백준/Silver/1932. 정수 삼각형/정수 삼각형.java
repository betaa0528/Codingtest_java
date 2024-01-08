import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int len = n - 1;
        int i = 0;
        StringTokenizer st;
        int[][] triangle = new int[n][n];
        int[][] triangle2 = new int[n][n];
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreElements()) {
                triangle[len - n][i++] = Integer.parseInt(st.nextToken());
            }
            i = 0;
        }

        for (int j = len - 1; j >= 0; j--) {
            for (int k = triangle[len].length - 2; k >= 0; k--) {
                triangle[j][k] += Math.max(triangle[j + 1][k + 1], triangle[j + 1][k]);
            }
        }
        System.out.println(triangle[0][0]);
    }
}