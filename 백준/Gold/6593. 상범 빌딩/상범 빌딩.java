import java.io.*;
import java.util.*;

public class Main {
    public static int[][] dir = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, -1}, {0, 0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            char[][][] building = new char[L][R][C];
            int[] start = new int[4];

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String s = br.readLine();
                    for (int k = 0; k < C; k++) {
                        if (s.charAt(k) == 'S') {
                            start = new int[]{i, j, k, 0};
                        }

                        building[i][j][k] = s.charAt(k);
                    }
                }
                br.readLine();
            }

            System.out.println(bfs(building, start, L, R, C));
        }
    }

    public static String bfs(char[][][] building, int[] start, int L, int R, int C) {
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[L][R][C];
        queue.add(start);
        visited[start[0]][start[1]][start[2]] = true;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            if(building[node[0]][node[1]][node[2]] == 'E') {
                return "Escaped in " + node[3] + " minute(s).";
            }
            for (int i = 0; i < dir.length; i++) {
                int nh = node[0] + dir[i][0];
                int nr = node[1] + dir[i][1];
                int nc = node[2] + dir[i][2];
                int cnt = node[3];

                if (nh < 0 || nh >= L || nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nh][nr][nc]) {
                    continue;
                }

                if (building[nh][nr][nc] == '#') {
                    continue;
                }

                queue.add(new int[]{nh, nr, nc, cnt+1});
                visited[nh][nr][nc] = true;
            }
        }
        return "Trapped!";
    }
}
