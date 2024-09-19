import java.io.*;
import java.util.*;

public class Main {
    public static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] jihun = new int[2];
        List<int[]> fires = new ArrayList<>();
        int answer = 0;

        String[][] graph = new String[r + 1][c + 1];
        for (int i = 1; i <= r; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                graph[i][j + 1] = arr[j] + "";
                if (arr[j] == 'J') {
                    jihun = new int[]{i, j + 1, 1};
                } else if (arr[j] == 'F') {
                    fires.add(new int[]{i, j + 1, 0});
                }
            }
        }

        Deque<int[]> queue = new ArrayDeque<>();
        int[][] visit = new int[r + 1][c + 1];
        for (int[] fire : fires) {
            queue.add(fire);
            visit[fire[0]][fire[1]] = 1;
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dir[i][0];
                int nc = cur[1] + dir[i][1];
                int time = cur[2];
                if (nr < 1 || nr >= r + 1 || nc < 1 || nc >= c + 1 || visit[nr][nc] == 1 || graph[nr][nc].equals("#")) {
                    continue;
                }

                queue.add(new int[]{nr, nc, time + 1});
                visit[nr][nc] = 1;
                graph[nr][nc] = (time + 1) + "";
            }
        }

        Deque<int[]> jQueue = new ArrayDeque<>();
        jQueue.add(jihun);
        int[][] jVisit = new int[r + 1][c + 1];
        jVisit[jihun[0]][jihun[1]] = 1;
        ji : while (!jQueue.isEmpty()) {
            int[] cur = jQueue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dir[i][0];
                int nc = cur[1] + dir[i][1];
                int time = cur[2];

                if(nr < 1 || nr > r || nc < 1 || nc > c) {
                    answer = time;
                    break ji;
                }

                if (jVisit[nr][nc] == 1 || graph[nr][nc].equals("#") || graph[nr][nc].equals("F")) {
                    continue;
                }

                if(graph[nr][nc].equals(".") || Integer.parseInt(graph[nr][nc]) > time) {
                    jQueue.add(new int[]{nr, nc, time + 1});
                    jVisit[nr][nc] = 1;
                }
            }
        }
        System.out.println(answer == 0 ? "IMPOSSIBLE" : answer);
    }
}
