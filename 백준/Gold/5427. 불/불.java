import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            String[] map = new String[r];
            Deque<int[]> q = new ArrayDeque<int[]>();
            int[][] fireVisit = new int[r][c];
            boolean[][] visited = new boolean[r][c];

            int[] s = new int[4];
            for(int j=0; j<r; j++) {
                map[j] = br.readLine();
                for(int k=0; k<c; k++) {
                    if(map[j].charAt(k) == '*') {
                        q.addLast(new int[] {j, k, 1, 0});
                        fireVisit[j][k] = 1;
                    }

                    if(map[j].charAt(k) == '@') {
                        s[0] = j;
                        s[1] = k;
                        s[2] = 1;
                        s[3] = 1;
                        visited[j][k] = true;
                    }
                }
            }
            bfs(map, r, c, q, fireVisit, visited);
            q.addLast(s);
            int result = bfs(map,r,c,q, fireVisit, visited);
            System.out.println(result == -1 ? "IMPOSSIBLE" : result);
        }

    }

    public static int bfs(String[] map, int r, int c, Deque<int[]> q, int[][] fireVisit, boolean[][] visited) {

        while(!q.isEmpty()) {
            int[] cur = q.pollFirst();
            for (int[] d : dir) {
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];

                if (cur[3] == 0) {
                    if (nr < 0 || nr >= r || nc < 0 || nc >= c || fireVisit[nr][nc] != 0 || map[nr].charAt(nc) == '#') {
                        continue;
                    }
                    q.add(new int[]{nr, nc, cur[2] + 1, cur[3]});
                    fireVisit[nr][nc] = cur[2] + 1;
                }

                if (cur[3] == 1) {

                    if (nr < 0 || nr >= r || nc < 0 || nc >= c) {
                        return cur[2];
                    }
                    if ((fireVisit[nr][nc] != 0 && fireVisit[nr][nc] <= cur[2] + 1) || visited[nr][nc] || map[nr].charAt(nc) == '*' || map[nr].charAt(nc) == '#') {
                        continue;
                    }
                    q.add(new int[]{nr, nc, cur[2] + 1, cur[3]});
                    visited[nr][nc] = true;
                }
            }
        }

        return -1;
    }
}
