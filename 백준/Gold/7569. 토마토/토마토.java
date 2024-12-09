import java.io.*;
import java.util.*;

public class Main {
    public static int[][] dir = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, -1}, {0, 0, 1}};
    public static int day;
    public static int zeroCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        Deque<int[]> queue = new ArrayDeque<>();
        int[][][] box = new int[h][n][m];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    int tomato = Integer.parseInt(st.nextToken());
                    zeroCnt = tomato == 0 ? zeroCnt + 1 : zeroCnt;
                    if(tomato == 1) {
                        queue.add(new int[]{i, j, k, 0});
                    }
                    box[i][j][k] = tomato;
                }
            }
        }
        bfs(box, queue,h,m,n);
        if(zeroCnt > 0) {
            System.out.println(-1);
        } else {
            System.out.println(day);
        }
    }

    public static void bfs(int[][][] box, Deque<int[]> queue, int h, int m, int n) {
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            for(int i=0; i<dir.length; i++) {
                int nh = node[0] + dir[i][0];
                int nr = node[1] + dir[i][1];
                int nc = node[2] + dir[i][2];
                int cnt = node[3];
                day = Math.max(day, cnt);
                if(nh < 0 || nh >= h || nr < 0 || nr >= n || nc < 0 || nc >= m || box[nh][nr][nc] == -1 || box[nh][nr][nc] == 1) {
                    continue;
                }

                box[nh][nr][nc] = 1;
                zeroCnt--;
                queue.add(new int[]{nh, nr, nc, cnt+1});
            }
        }
    }
}
