import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] map;
    static boolean[] visited;
    static boolean[] done;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            map = new int[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            visited = new boolean[N + 1];
            done = new boolean[N + 1];
            for (int j = 1; j <= N; j++) {
                map[j] = Integer.parseInt(st.nextToken());
            }
            cnt = 0;
            for (int j = 1; j <= N; j++) {
                if (!visited[j]) {
                    dfs(j, map, visited, done);
                }
            }
            System.out.println(N - cnt);
        }
    }

    public static void dfs(int cur, int[] map, boolean[] visited, boolean[] done) {
        visited[cur] = true;
        int next = map[cur];

        if (!visited[next]) {   
            dfs(next, map, visited, done);
        } else if (!done[next]) {
            cnt++;
            for (int i = next; i != cur; i = map[i]) {
                cnt++;
            }
        }

        done[cur] = true;
    }
}

