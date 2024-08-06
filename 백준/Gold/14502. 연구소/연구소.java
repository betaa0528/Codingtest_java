import java.util.*;
import java.io.*;

class Main{
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {1, 0, -1, 0};
    public static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int row = 0;
        int col = 0;
        String[] s = br.readLine().split(" ");
        List<int[]> virusList = new ArrayList<>();
        row = Integer.parseInt(s[0]);
        col = Integer.parseInt(s[1]);
        int[][] graph = new int[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreElements()) {
                int a = Integer.parseInt(st.nextToken());
                if(a == 2) {
                    virusList.add(new int[]{i, j});
                }
                graph[i][j++] = a;
            }
        }
        int[][] copy = new int[row][col];
        for (int i = 0; i < row; i++) {
            copy[i] = Arrays.copyOf(graph[i], graph[0].length);
        }
        int[][] visit = new int[row][col];
        dfs(graph, 0, visit, virusList );
        System.out.println(answer);
    }
    
    public static int countZero(int[][] graph) {
        int result = 0;
        for (int[] gra : graph) {
            for (int g : gra) {
                if (g == 0) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void bfs(int[][] graph, boolean[][] visit, int[] start) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(start);
        visit[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] q = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = q[0] + dx[i];
                int ny = q[1] + dy[i];
                if (nx < 0 || nx >= graph.length || ny < 0 || ny >= graph[nx].length) {
                    continue;
                }
                if (visit[nx][ny] || graph[nx][ny] == 1 || graph[nx][ny] == 2) {
                    continue;
                }
                graph[nx][ny] = 2;
                visit[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }
    }

    public static void dfs(int[][] graph, int cnt, int[][] visit, List<int[]> start) {
        if(cnt == 3) {
            int result = 0;
            boolean[][] bfsVisit = new boolean[graph.length][graph[0].length];
            int[][] copy = new int[graph.length][graph[0].length];
            for (int i = 0; i < graph.length; i++) {
                copy[i] = Arrays.copyOf(graph[i], graph[0].length);
            }
            for(int[] s: start) {
                bfs(copy, bfsVisit, s);
            }
            result = countZero(copy);
            answer = Math.max(result, answer);
            return;
        }

        for(int i = 0; i<graph.length; i++ ) {
            for (int j = 0; j < graph[0].length; j++) {
                if(graph[i][j] != 0 || visit[i][j] != 0) {
                    continue;
                }
                graph[i][j] = 1;
                visit[i][j] = 1;
                dfs(graph, cnt+1 ,visit, start);
                graph[i][j] = 0;
                visit[i][j] = 0;
            }
        }
    }
}