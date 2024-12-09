import java.util.*;
import java.io.*;

public class Main {
    public static int answer;
    public static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        String[] map = new String[r];
        answer = Integer.MAX_VALUE;
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine();
        }

        bfs(map, new int[]{0, 0, 0, 1}, new boolean[r][c][2], 0);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);

    }

    public static void bfs(String[] map, int[] s, boolean[][][] visit, int check) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(s);
        visit[s[0]][s[1]][0] = true;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            if (check == 0 && (node[0] == map.length - 1) && (node[1] == map[node[0]].length() - 1)) {
                answer = Math.min(answer, node[3]);
            }
            for (int i = 0; i < dir.length; i++) {
                int nr = node[0] + dir[i][0];
                int nc = node[1] + dir[i][1];
                int jump = node[2];
                int cnt = node[3];
                if (nr < 0 || nr >= map.length || nc < 0 || nc >= map[nr].length()) {
                    continue;
                }

                if (map[nr].charAt(nc) == '0' && !visit[nr][nc][jump]) {

                    visit[nr][nc][jump] = true;
                    queue.add(new int[]{nr, nc, jump, cnt + 1});

                }
                if(map[nr].charAt(nc) == '1' && jump == 0 && !visit[nr][nc][1]) {
                    visit[nr][nc][1] = true;
                    queue.add(new int[]{nr, nc, 1, cnt + 1});
                }
            }
        }
    }
}
