import java.util.*;
import java.io.*;
public class Main{
    static boolean[] visit;
    static int[] arr;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
//        st = new StringTokenizer(br.readLine());
        Scanner sc = new Scanner(System.in);
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visit = new boolean[N];
        arr = new int[M];
        dfs(N, M, 0, 0);
        bw.flush();
        bw.close();
    }

    private static void dfs(int N, int M, int depth, int idx) throws IOException {
        if (depth == M) {
            for (int num : arr) {
                bw.write(num + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = idx; i < N; i++) {
            if (visit[i] == false) {

                visit[i] = true;
                arr[depth] = i + 1;
                dfs(N, M, depth + 1, i+1);

                visit[i] = false;
            }
        }
    }
}