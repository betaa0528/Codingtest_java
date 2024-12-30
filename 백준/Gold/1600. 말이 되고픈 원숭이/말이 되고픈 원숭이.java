import java.io.*;
import java.util.*;

public class Main {
    public static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static int[][] horse = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {2, 1}, {1, 2}, {2, -1}, {1, -2}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[][] map = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs(map, r, c, K));
    }

    public static int bfs(int[][] map, int r, int c, int K) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, K, 0}); // 행, 열, 남아있는 횟수, 움직인 횟수
        boolean[][][] visit = new boolean[r][c][K + 1]; // 0은 그냥 한칸 이동 1은 말로 이동
        visit[0][0][0] = true;
        visit[0][0][K] = true;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            if (node[0] == r - 1 && node[1] == c - 1) {
                return node[3];
            }
            for (int i = 0; i < dir.length; i++) {
                int nr = node[0] + dir[i][0];
                int nc = node[1] + dir[i][1];
                int jump = node[2];
                int cnt = node[3];
                if (nr < 0 || nr >= r || nc < 0 || nc >= c || visit[nr][nc][K - jump]) {
                    continue;
                }

                if (map[nr][nc] == 1) {
                    continue;
                }

                queue.add(new int[]{nr, nc, jump, cnt + 1});
                visit[nr][nc][K - jump] = true;
            }

            for (int j = 0; j < horse.length; j++) {
                int nr = node[0] + horse[j][0];
                int nc = node[1] + horse[j][1];
                int jump = node[2];
                int cnt = node[3];
                if (nr < 0 || nr >= r || nc < 0 || nc >= c || jump < 1 || visit[nr][nc][K + 1 - jump]) {
                    continue;
                }

                if (map[nr][nc] == 1) {
                    continue;
                }

                queue.add(new int[]{nr, nc, jump - 1, cnt + 1});
                visit[nr][nc][K + 1 - jump] = true;
            }
        }

        return -1;
    }
}
