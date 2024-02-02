import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] items = new int[N + 1][2];
        int[][] bag = new int[N + 1][K + 1];
        for (int i = 1; i < items.length; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int j = 1; j < bag.length; j++) {
            for (int k = 1; k < bag[0].length; k++) {
                if (k >= items[j][0]) {
                    bag[j][k] = Math.max(findMax(bag, j, k - items[j][0]) + items[j][1], findMax(bag, j, k));
                } else {
                    bag[j][k] = bag[j-1][k];
                }
            }
        }
        System.out.println(bag[N][K]);

    }
    private static int findMax(int[][] bag, int row, int col) {
        if (row == 0) return 0;
        return bag[row - 1][col];
    }
}