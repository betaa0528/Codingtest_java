import java.util.*;
class Solution {
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {1, 0, -1, 0};
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i = 0; i < 5; i++) {
            char[][] graph = new char[5][5];
            List<int[]> pList = new ArrayList<>();

            int[][] map = new int[5][5];
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    char val = places[i][j].charAt(k);
                    graph[j][k] = val;
                    if (val == 'P') {
                        pList.add(new int[]{j, k});
                    }
                }
            }
            answer[i] = 1;
            for (int[] p : pList) {
                boolean[][] visit = new boolean[5][5];
                if(!bfs(p, graph, map, visit)) {
                    answer[i] = 0;
                    break;
                }
            }
        }
        return answer;
    }
    
    public static boolean bfs(int[] p, char[][] graph, int[][] map, boolean[][] visit) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(p);
        visit[p[0]][p[1]] = true;
        while(!queue.isEmpty()) {
            int[] coor = queue.poll();
            int x = coor[0];
            int y = coor[1];
            if(map[x][y] == 3) {
                return true;
            }
            for(int i=0; i<4; i++) {
                int cur_x = x + dx[i];
                int cur_y = y + dy[i];
                if(cur_x < 0 || cur_x >= 5 || cur_y < 0 || cur_y >= 5) {
                    continue;
                }
                if(!visit[cur_x][cur_y] && graph[cur_x][cur_y] != 'X') {
                    queue.add(new int[] {cur_x, cur_y});
                    visit[cur_x][cur_y] = true;
                    map[cur_x][cur_y] = map[x][y] + 1;
                    if(map[cur_x][cur_y] <= 2 && graph[cur_x][cur_y] == 'P') {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}