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
        char[][] smap = new char[r][c];
        int[][] map = new int[r][c];
        for(int[] m : map) {
            Arrays.fill(m, Integer.MAX_VALUE);
        }
        Deque<int[]> water = new ArrayDeque<>();
        int[] beaver = new int[3];
        for(int i=0; i<r; i++) {
            String s = br.readLine();
            for(int j=0; j<c; j++) {
                smap[i][j] = s.charAt(j);
                if(smap[i][j] == '*') {
                    water.add(new int[]{i, j, 0});
                } else if(smap[i][j] == 'S') {
                    beaver[0] = i;
                    beaver[1] = j;
                 }
            }
        }
        waterDiffusion(smap, map, water, r, c);
        
        int answer = bfs(smap, map, r, c, beaver);
        System.out.println(answer == -1 ? "KAKTUS" : answer);
    }

    public static int bfs(char[][] smap, int[][] map, int r, int c, int[] s) {
        boolean[][] visit = new boolean[r][c];
        Deque<int[]> q = new ArrayDeque<>();
        q.add(s);
        visit[s[0]][s[1]] = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();

//            System.out.println(cur[0] + " , " + cur[1]);

            for(int[] d : dir) {
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];
                if(nr < 0 || nr >= r || nc < 0 || nc >= c) {
                    continue;
                }
                if(smap[nr][nc] == 'D') {
                    return cur[2] + 1;
                }
                if(visit[nr][nc] || smap[nr][nc] == 'X' || map[nr][nc] <= cur[2] + 1) {
                    continue;
                }
                visit[nr][nc] = true;
                q.add(new int[]{nr, nc, cur[2] + 1});
            }
        }
        return -1;
    }

    public static void waterDiffusion(char[][] smap, int[][] map, Deque<int[]> water, int r, int c) {
        boolean[][] visit = new boolean[r][c];
        while(!water.isEmpty()) {
            int[] cur = water.poll();
            visit[cur[0]][cur[1]] = true;
            for(int[] d: dir) {
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];
                if(nr < 0 || nr >= r || nc < 0 || nc >= c || visit[nr][nc] || smap[nr][nc] == 'D' || smap[nr][nc] == '*' || smap[nr][nc] == 'X') {
                    continue;
                }

                water.add(new int[]{nr, nc, cur[2] + 1});
                map[nr][nc] = cur[2] + 1;
                visit[nr][nc] = true;
            }
        }
    }
}
