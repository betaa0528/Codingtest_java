import java.util.*;
class Solution {
    public static int[][] dir = {{-1,0}, {0,-1}, {1, 0}, {0, 1}};
    public int solution(String[] board) {
        int answer = 0;
        int[] s = new int[4];
        s[3] = -1;
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length(); j++) {
                if(board[i].charAt(j) == 'R') {
                    s[0] = i;
                    s[1] = j;
                }
            }
        }
        answer = bfs(board, s);
        return answer;
    }
    
    public static int bfs(String[] board, int[] s) {
        boolean[][] visit = new boolean[board.length][board[0].length()];
        visit[s[0]][s[1]] = true;
        Deque<int[]> q = new ArrayDeque<>();
        q.add(s);
        
        while(!q.isEmpty()) {
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];
            if(board[r].charAt(c) == 'G') {
                return node[2];
            }
            for(int i=0; i<dir.length; i++) {
                if(node[3] % 2 == 0) {
                    if(i % 2 == 0) {
                        continue;
                    }
                } else if(node[3] % 2 == 1) {
                    if(i% 2!= 0) {
                        continue;
                    }
                }
                int nr = r;
                int nc = c;
                while(true) {
                    if(nr < 0 || nr == board.length || nc < 0 || nc == board[0].length() || board[nr].charAt(nc) == 'D') {
                        break;
                    }
                    nr = dir[i][0] + nr;
                    nc = dir[i][1] + nc;
                }
                if(visit[nr - dir[i][0]][nc - dir[i][1]]) continue;
                visit[nr - dir[i][0]][nc - dir[i][1]] = true;
                q.add(new int[]{nr - dir[i][0], nc - dir[i][1], node[2]+1, i});
            }
        }
        
        return -1;
    }
}