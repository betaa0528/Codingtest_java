import java.util.*;
class Solution {
    public static int answer = 0;
    public int solution(int m, int n, String[] board) {
        
        char[][] map = new char[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }
        boolean flag = true;
        while(flag) {
            flag = chk(map, m, n);
            move(map);
        }

        return answer;
    }
    
    public static void move(char[][] map) {
        for(int i=map.length-2; i>=0; i--) {
            for(int j=0; j<map[0].length; j++) {
                if(map[i][j] == '1') {
                    continue;
                }
                int nr = i;
                while (nr + 1 < map.length && map[nr + 1][j] == '1') {
                    nr++;
                }

                if (nr != i) {
                    map[nr][j] = map[i][j];
                    map[i][j] = '1';
                }
            }
        }
    }
    
    public static boolean chk(char[][] map, int m, int n) {
        int[][] dir = {{1,0}, {1,1}, {0,1}};
        Deque<int[]> q = new ArrayDeque<>();
        for(int i=0; i<m-1; i++) {
            for(int j=0; j<n-1; j++) {
                int[] now = {i,j};
                if(map[i][j] == '1') continue;

                int cnt = 1;
                for(int k=0; k<3; k++) {
                    int nr = now[0] + dir[k][0];
                    int nc = now[1] + dir[k][1];
                    
                    if(map[i][j] == map[nr][nc]) {
                        cnt++;
                    }
                }
                if(cnt == 4) {
                    q.push(now);
                    for(int k=0; k<3; k++) {
                        int nr = now[0] + dir[k][0];
                        int nc = now[1] + dir[k][1];
                        q.push(new int[]{nr, nc});
                    }
                }
            }
        }
        boolean flag = false;
        while(!q.isEmpty()) {
            
            int[] node = q.pop();
            if(map[node[0]][node[1]] != '1') {
                flag = true;
                answer++;
            }
            map[node[0]][node[1]] = '1';

           
        }
        return flag;
    }
}