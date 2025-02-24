import java.util.*;
class Solution {
    public int solution(String[] maps) {
        int answer = 0;
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] goal = new int[2];
        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[0].length(); j++) {
                if(maps[i].charAt(j) == 'S') {
                    start = new int[]{i, j};
                }
                if(maps[i].charAt(j) == 'L') {
                    lever = new int[]{i, j};
                }
                if(maps[i].charAt(j) == 'E') {
                    goal = new int[]{i,j};
                }
            }
        }
        int toLever = bfs(start, maps, lever);
        if(toLever == -1) return -1;
        int toGoal = bfs(lever, maps, goal);
        if(toGoal == -1) return -1;
        return toLever + toGoal;
    }
    
    public static int bfs(int[] start,String[] maps, int[] end) {
        int[][] dir = {{1,0}, {0,-1}, {0,1}, {-1,0}};
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[maps.length][maps[0].length()];
        visit[start[0]][start[1]] = true;
        q.add(new int[]{start[0], start[1], 0});
        while(!q.isEmpty()) {
            int[] node = q.poll();
            for(int i=0; i<4; i++) {
                int nr = node[0] + dir[i][0];
                int nc = node[1] + dir[i][1];
                if(nr < 0 || nr >= maps.length || nc < 0 || nc >= maps[0].length() || visit[nr][nc] || maps[nr].charAt(nc) == 'X') {
                    continue;
                }
                if(nr == end[0] && nc == end[1]) {
                    return node[2] + 1;
                }
                visit[nr][nc] = true;
                q.add(new int[]{nr, nc, node[2] + 1});
            }
        }
        return -1;
    }
}