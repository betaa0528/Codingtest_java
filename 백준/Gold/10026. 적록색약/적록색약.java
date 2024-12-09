import java.util.*;
import java.io.*;
public class Main {
    public static int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] map = new String[n];
        for(int i=0; i<n; i++) {
            map[i] = br.readLine();
        }

        boolean[][] visit1 = new boolean[n][n]; // 정상
        boolean[][] visit2 = new boolean[n][n]; // 적록색맹
        int[] answer = new int[2];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!visit1[i][j]) {
                    bfs(map, n, new int[]{i,j}, visit1, 0);
                    answer[0]++;
                }

                if(!visit2[i][j]) {
                    bfs(map, n, new int[]{i,j}, visit2, 1);
                    answer[1]++;
                }
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }

    public static void bfs(String[] map, int n, int[] start, boolean[][] visit, int check) { // 0 이면 정상 1이면 적록 색맹
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(start);
        char now = map[start[0]].charAt(start[1]);
        visit[start[0]][start[1]] = true;
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            for(int i=0; i<4; i++) {
                int nr = node[0] + dir[i][0];
                int nc = node[1] + dir[i][1];

                if(nr < 0 || nr >= n || nc < 0 || nc >= n || visit[nr][nc]) {
                    continue;
                }

                if(check == 0) {
                    if(map[nr].charAt(nc) != now) {
                        continue;
                    }
                    visit[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                } else {
                    if(now == 'B' && map[nr].charAt(nc) != now) {
                        continue;
                    } else if((now == 'R' || now == 'G') && map[nr].charAt(nc) == 'B') {
                        continue;
                    }
                    visit[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
    }
}