import java.util.*;
class Solution {
    public int[] solution(int n) {
        int[][] dir = {{1, 0}, {0,1}, {-1, -1}};
        int[][] map = new int[n][n];
        int num = 2;
        int r = 0;
        int c = 0;
        int d = 0;
        map[0][0] = 1;
        int max = n % 2 == 0? (n +1) * ((n+1)/ 2) : (n+1) * (n/2) + (n+1)/2;
        while(num <= max) {
            int nr = dir[d%3][0] + r;
            int nc = dir[d%3][1] + c;
            if(nr < 0 || nr >= n || nc < 0 || nc >= n || map[nr][nc] != 0) {
                d++;
                continue;
            }
            map[nr][nc] = num++;
            r = nr;
            c = nc;
        }
        int[] answer = new int[max];
        int idx = 0;
        for(int[] ma : map) {
            for(int m : ma) {
                if(m != 0) {
                    answer[idx++] = m;
                }
            }
        }
        
        return answer;
    }
}