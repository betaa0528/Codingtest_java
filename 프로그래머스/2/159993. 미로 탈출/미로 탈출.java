import java.util.*;
class Solution {
    public int solution(String[] maps) {
        int s = 0; 
        int e = 0;
        int[] lever = new int[2];
       
        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[0].length(); j++) {   
                if(maps[i].charAt(j) == 'L') {
                    lever = new int[]{i, j};
                }
            }
        }
        
        int[][] dir = {{1,0}, {0,-1}, {0,1}, {-1,0}};
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[maps.length][maps[0].length()];
        visit[lever[0]][lever[1]] = true;
        q.add(new int[]{lever[0], lever[1], 0});
        while(!q.isEmpty()) {
            int[] node = q.poll();
            for(int i=0; i<4; i++) {
                int nr = node[0] + dir[i][0];
                int nc = node[1] + dir[i][1];
                if(nr < 0 || nr >= maps.length || nc < 0 || nc >= maps[0].length() || visit[nr][nc] || maps[nr].charAt(nc) == 'X') {
                    continue;
                }
                if(maps[nr].charAt(nc) == 'S') {
                    s = node[2] + 1;
                }
                
                if(maps[nr].charAt(nc) == 'E') {
                    e = node[2] + 1;
                }
                visit[nr][nc] = true;
                q.add(new int[]{nr, nc, node[2] + 1});
            }
        }
        if(s == 0 || e == 0) {
            return -1;
        }
        return s+e;
    }

}