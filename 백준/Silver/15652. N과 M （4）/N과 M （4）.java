import java.io.*;
import java.util.*;
public class Main{
    static boolean[] visit;
    static int[] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visit = new boolean[N + 1];
        arr = new int[M];
        solution(N, M, 0);
    }

    private static void solution(int n, int m, int cnt) throws IOException {
        if (cnt == m) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                if(cnt > 0 && i < arr[cnt-1]) {
                    continue;
                }
                arr[cnt] = i;
                solution(n, m, cnt + 1);
            }
        }
    }

}