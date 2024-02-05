import java.util.*;
import java.io.*;

public class Main{
    static String[] square;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        square = new String[N];
        for (int i = 0; i < N; i++) {
            square[i] = br.readLine();
        }
        quad(N, 0, 0);

        System.out.println(answer.toString());
    }

    private static void quad(int N, int x, int y) {
        int zeroCnt = 0;
        for (int i = x; i < x + N; i++) {
            for (int j = y; j < y + N; j++) {
                if (square[i].charAt(j) == '0') {
                    zeroCnt++;
                }
            }
        }
        if (zeroCnt == N * N) {
            answer.append("0");
        } else if (zeroCnt == 0) {
            answer.append("1");
        } else {
            answer.append("(");
            quad(N / 2, x, y);
            quad(N / 2, x, y + N / 2);
            quad(N / 2, x + N / 2, y);
            quad(N / 2, x + N / 2, y + N / 2);
            answer.append(")");
        }
    }
}