import java.util.*;
import java.io.*;

public class Main {
    public static int[][] dir = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {1, -2}, {2, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int[] answer = new int[tc];
        for(int i=0; i<tc; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] s = {Integer.parseInt(st.nextToken()) , Integer.parseInt(st.nextToken()), 0};
            st = new StringTokenizer(br.readLine());
            int[] e = {Integer.parseInt(st.nextToken()) , Integer.parseInt(st.nextToken())};
            answer[i] = bfs(new int[n][n], n, s, e);
        }
        for(int ans : answer) {
            System.out.println(ans);
        }
    }

    public static int bfs(int[][] chess, int n, int[] s, int[] e) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(s);
        boolean[][] visit = new boolean[n][n];
        visit[s[0]][s[1]] = true;
        int min = 0;
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            if(node[0] == e[0] && node[1] == e[1]) {
                return node[2];
            }
            for(int i=0; i<dir.length; i++) {
                int nr = node[0] + dir[i][0];
                int nc = node[1] + dir[i][1];
                int cnt = node[2];
                if(nr < 0 || nr >= n || nc < 0 || nc >= n || visit[nr][nc]) {
                    continue;
                }
                visit[nr][nc] = true;
                queue.add(new int[]{nr, nc, cnt+1});
            }
        }
        return min;
    }
}
