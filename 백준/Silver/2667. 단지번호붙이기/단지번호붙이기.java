import java.io.*;
import java.util.*;

public class Main {
    public static int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] map = new String[N];
        boolean[][] visited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            map[i] = br.readLine();
        }

        Deque<int[]> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j] && map[i].charAt(j) == '1') {
                    queue.add(new int[]{i,j});
                    visited[i][j] = true;
                    bfs(map, visited, queue, list);
                }
            }
        }
        System.out.println(list.size());
        Collections.sort(list);
        for(int n : list) {
            System.out.println(n);
        }
    }

    public static void bfs(String[] map, boolean[][] visited, Deque<int[]> queue, List<Integer> list) {
        int cnt = 1;
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            for(int i=0; i<dir.length; i++) {
                int nr = node[0] + dir[i][0];
                int nc = node[1] + dir[i][1];

                if(nr < 0 || nr >= map.length || nc < 0 || nc >= map[nr].length() || visited[nr][nc]) {
                    continue;
                }
                if(map[nr].charAt(nc) == '0') {
                    continue;
                }
                cnt++;
                visited[nr][nc] = true;
                queue.add(new int[]{nr, nc});
            }
        }
        list.add(cnt);
    }
}
