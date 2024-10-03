import java.io.*;
import java.util.*;

public class Main {
    public static int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int quantity = Integer.parseInt(st.nextToken());
        boolean[][] visit = new boolean[r][c];
        int[][] graph = new int[r][c];
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<quantity; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            for(int j=r1; j<r2; j++) {
                for(int k=c1; k<c2; k++) {
                    graph[j][k] = 1;
                }
            }
        }

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(graph[i][j] == 0 && !visit[i][j]) {
                    answer++;
                    int result = bfs(graph, new int[]{i,j}, visit);
                    list.add(result);
                }
            }
        }
        list.sort(Comparator.naturalOrder());
        System.out.println(answer);
        for(int num : list) {
            System.out.print(num + " ");
        }
    }

    public static int bfs(int[][] graph, int[] start, boolean[][] visit) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(start);
        visit[start[0]][start[1]] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.pollFirst();
            for(int i=0; i<4; i++) {
                int nr = cur[0] + dir[i][0];
                int nc = cur[1] + dir[i][1];
                if(nr < 0 || nr >= graph.length || nc < 0 || nc >= graph[0].length || visit[nr][nc]) {
                    continue;
                }

                if (graph[nr][nc] == 1) {
                    continue;
                }

                visit[nr][nc] = true;
                queue.addLast(new int[]{nr, nc});
                count++;
            }
        }
        return count+1;
    }
}
