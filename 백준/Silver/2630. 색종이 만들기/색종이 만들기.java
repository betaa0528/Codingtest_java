import java.util.*;
import java.io.*;
public class Main{
    static int blue;
    static int white;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cutPaper(paper, N);

        System.out.println(white);
        System.out.println(blue);

    }

    private static void cutPaper(int[][] paper, int N) {
        if (N == 1) {
            if (paper[0][0] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }
        int whiteCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
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
            cutPaper(cutting(paper, N, 1), N/2);
            cutPaper(cutting(paper, N, 2), N/2);
            cutPaper(cutting(paper, N, 3), N/2);
            cutPaper(cutting(paper, N, 4), N/2);
        }
    }

    private static int[][] cutting(int[][] paper, int N, int order) {
        int[][] quarter = new int[N / 2][N / 2];

        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < N / 2; j++) {
                if (order == 1) {
                    quarter[i][j] = paper[i][j];
                } else if (order == 2) {
                    quarter[i][j] = paper[i][j + N / 2];
                } else if (order == 3) {
                    quarter[i][j] = paper[i + N / 2][j];
                } else if (order == 4) {
                    quarter[i][j] = paper[i + N / 2][j + N / 2];
                }
            }
        }
        return quarter;
    }
}