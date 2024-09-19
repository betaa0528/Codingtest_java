import java.util.*;
class Solution {
    public static int[][] dir = {{1,0}, {-1,0}, {0, 1}, {0,-1}};
    public int solution(int[][] maps) {
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] visit = new int[maps.length][maps[0].length];
        queue.add(new int[]{0,0,1});
        visit[0][0] = 1;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for(int i=0; i<4; i++) {
                int nr = cur[0] + dir[i][0];
                int nc = cur[1] + dir[i][1];
                int dist = cur[2];
                if(nr < 0 || nr >= maps.length || nc < 0 || nc>= maps[0].length || visit[nr][nc] == 1 || maps[nr][nc] == 0) {
                    continue;
                }
                
                if(nr == maps.length-1 && nc == maps[0].length-1) {
                    return dist + 1;
                }
                queue.add(new int[]{nr, nc, dist+1});
                visit[nr][nc] = 1;

            }
        }
        return -1;
    }
}