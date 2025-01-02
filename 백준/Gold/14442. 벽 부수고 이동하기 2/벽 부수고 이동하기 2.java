import java.io.*;
import java.util.*;
public class Main {
    public static int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String[] map = new String[r];
        for(int i=0; i<r; i++) {
            map[i] = br.readLine();
        }

        int answer = bfs(map, r, c, K);
        System.out.println(answer);
    }

    public static int bfs(String[] map, int r, int c, int K){
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0,0,K}); // 행, 열, cnt, 횟수
        boolean[][][] visited = new boolean[r][c][K+1];
        visited[0][0][K] = true;
        visited[0][0][0] = true;

        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            if(node[0] == r-1 && node[1] == c-1) {
                return node[2]+1;
            }
            for(int i=0; i<dir.length; i++) {
                int nr = node[0] + dir[i][0];
                int nc = node[1] + dir[i][1];
                int cnt = node[2];
                int jump = node[3];

                if(nr < 0 || nr >= r || nc < 0 || nc >= c) {
                    continue;
                }

                if(map[nr].charAt(nc) == '0' && !visited[nr][nc][K-jump] ) {
                    queue.add(new int[]{nr, nc, cnt+1 , jump});
                    visited[nr][nc][K-jump] = true;
                }

                if(map[nr].charAt(nc) == '1' && jump > 0 && !visited[nr][nc][K+1-jump]) {
                    queue.add(new int[]{nr, nc, cnt + 1, jump - 1});
                    visited[nr][nc][K+1-jump] = true;
                }
            }
        }

        return -1;
    }
}
