import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[][] map = new int[r][c];
        int[][] ans = new int[r][c];
        int[] start = new int[3];
        for(int i=0;i<r;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<c;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    ans[i][j] = -1;
                }
                if(map[i][j] == 2) {
                    start = new int[]{i, j, 0};
                    map[i][j] = 0;
                }
            }
        }
        bfs(map, r, c, ans, start);
        for(int[] an : ans) {
            for(int a : an) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }

    public static void bfs(int[][] map, int r, int c, int[][] ans, int[] start) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(start);
        boolean[][] visit = new boolean[r][c];
        visit[start[0]][start[1]] = true;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for(int i=0; i<4; i++) {
                int nr = cur[0] + dir[i][0];
                int nc = cur[1] + dir[i][1];
                int cnt = cur[2];

                if(nr < 0 || nr >= r || nc < 0 || nc >= c || visit[nr][nc] || map[nr][nc] == 0) {
                    continue;
                }

                queue.add(new int[]{nr, nc, cnt+1});
                visit[nr][nc] = true;
                ans[nr][nc] = cnt+1;
            }
        }
    }
}
