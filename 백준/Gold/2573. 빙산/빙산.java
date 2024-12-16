import java.io.*;
import java.util.*;

public class Main {
    public static int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[][] maps = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;

        a : while (true) {
            boolean[][] visited = new boolean[r][c];
            int cnt = 0;
            int zeroCnt = 0;
            int[][] mapsCopy = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    zeroCnt = maps[i][j] == 0 ? zeroCnt + 1 : zeroCnt;
                    if (maps[i][j] != 0 && !visited[i][j]) {
                        cnt++;
                        mapsCopy = bfs(maps, visited, new int[]{i, j});
                    }
                }
            }
            maps = mapsCopy;
            answer++;
            if (cnt == 0) {
                if(zeroCnt == r * c) {
                    answer = 0;
                    break a;
                }
            }
            else if(cnt > 1) {
                answer = answer - 1;
                break a;
            }
        }
        System.out.println(answer);
    }

    public static int[][] bfs(int[][] maps, boolean[][] visited, int[] s) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(s);
        int[][] mapsCopy = new int[maps.length][maps[0].length];
        boolean[][] isChecked = new boolean[maps.length][maps[0].length];
        isChecked[s[0]][s[1]] = true;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int cnt = 0;
            visited[node[0]][node[1]] = true;
            for (int i = 0; i < dir.length; i++) {
                int nr = node[0] + dir[i][0];
                int nc = node[1] + dir[i][1];

                if (nr < 0 || nr >= maps.length || nc < 0 || nc >= maps[nr].length || isChecked[nr][nc]) {
                    continue;
                }

                if (maps[nr][nc] == 0) {
                    cnt++;
                }

                if (maps[nr][nc] != 0) {
                    isChecked[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                }
            }
            mapsCopy[node[0]][node[1]] = maps[node[0]][node[1]] - cnt < 0 ? 0 : maps[node[0]][node[1]] - cnt;
        }
        return mapsCopy;
    }
}

