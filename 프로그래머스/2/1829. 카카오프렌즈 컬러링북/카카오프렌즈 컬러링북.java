import java.util.*;
class Solution {
    public static int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        boolean[][] visit = new boolean[m][n];
        for(int i=0; i<m ;i++) {
            for(int j=0; j<n; j++) {
                if(picture[i][j] != 0 && !visit[i][j]) {
                    maxSizeOfOneArea = Math.max(bfs(picture, visit, new int[]{i, j, picture[i][j]}, m, n), maxSizeOfOneArea);
                    numberOfArea++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    public static int bfs(int[][] picture, boolean[][] visit, int[] s, int m, int n) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(s);
        int area = 1;
        visit[s[0]][s[1]] = true;
        while(!q.isEmpty()) {
            int[] node = q.poll();
            for(int i=0; i<dir.length; i++) {
                int nr = dir[i][0] + node[0];
                int nc = dir[i][1] + node[1];
                if(nr < 0 || nr >= m || nc < 0 || nc >= n || visit[nr][nc] || picture[nr][nc] != node[2] || picture[nr][nc] == 0) {
                    continue;
                }
                visit[nr][nc] = true;
                area++;
                q.add(new int[]{nr, nc, node[2]});
            }
        }
        
        return area;
    }
    // 1110
    // 1220
    // 1001
    // 0001
    // 0003
    // 0003
}