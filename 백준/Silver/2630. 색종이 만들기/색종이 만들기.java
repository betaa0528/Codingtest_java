import java.util.*;
import java.io.*;
public class Main{
    static int blue;
    static int white;
    static int[][] paper;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cutPaper(N, 0, 0);
        System.out.println(white);
        System.out.println(blue);
    }
    private static void cutPaper(int N,int x,int y) {
        int whiteCnt = 0;
        for (int i = x; i < x + N; i++) {
            for (int j = y; j < y + N; j++) {
                if (paper[i][j] == 0) {
                    whiteCnt++;
                }
            }
        }
        if (whiteCnt == N * N) {
            white++;
        } else if (whiteCnt == 0) {
            blue++;
        } else {
            cutPaper(N / 2, x, y);
            cutPaper(N / 2, x, y + N / 2);
            cutPaper(N / 2, x + N / 2, y);
            cutPaper(N / 2, x + N / 2, y + N / 2);
        }
    }
}