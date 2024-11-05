import java.util.*;
class Solution {
    public static int[][] dir = {{1,0}, {-1,0}, {0, 1}, {0,-1}};
    public int solution(int[][] maps) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[maps.length][maps[0].length];
        queue.add(new int[]{0,0,1});
        visit[0][0] = true;
        int answer = -1;
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int cnt = node[2];
            if(node[0] == maps.length - 1 && node[1] == maps[node[0]].length - 1) {
                answer = cnt;
                break;
            }
            for(int i=0; i<dir.length; i++) {
                int nr = dir[i][0] + node[0];
                int nc = dir[i][1] + node[1];
                if(nr < 0 || nr >= maps.length || nc < 0 || nc >= maps[nr].length || visit[nr][nc] || maps[nr][nc] == 0) {
                    continue;
                }
                queue.add(new int[]{nr, nc, cnt+1});
                visit[nr][nc] = true;
            }
        }
        return answer;
    }
}