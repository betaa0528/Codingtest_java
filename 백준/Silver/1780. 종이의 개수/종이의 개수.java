import java.io.*;
import java.util.*;
public class Main{
    static int minus;
    static int zero;
    static int one;
    static int[][] square;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        square = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                square[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cutPaper(N, 0, 0);

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(one);

    }

    private static void cutPaper(int N, int x, int y) {
        int minusCnt = 0;
        int zeroCnt = 0;
        int oneCnt = 0;
        for (int i = x; i < x + N; i++) {
            for (int j = y; j < y + N; j++) {
                if (square[i][j] == -1) {
                    minusCnt++;
                } else if(square[i][j] == 0 ) {
                    zeroCnt++;
                } else {
                    oneCnt++;
                }
            }
        }
        if (minusCnt == N * N) {
            minus++;
        } else if (zeroCnt == N*N) {
            zero++;
        } else if(oneCnt == N*N) {
            one++;
        } else {
            cutPaper(N / 3, x, y);
            cutPaper(N / 3, x, y + N / 3);
            cutPaper(N / 3, x, y + (N / 3) * 2);
            cutPaper(N / 3, x + N / 3, y);
            cutPaper(N / 3, x + N / 3, y + N / 3);
            cutPaper(N / 3, x + N / 3, y + (N / 3) * 2);
            cutPaper(N / 3, x + (N / 3) * 2, y );
            cutPaper(N / 3, x + (N / 3) * 2, y + N / 3);
            cutPaper(N / 3, x + (N / 3) * 2, y + (N / 3) * 2);
        }
    }
}