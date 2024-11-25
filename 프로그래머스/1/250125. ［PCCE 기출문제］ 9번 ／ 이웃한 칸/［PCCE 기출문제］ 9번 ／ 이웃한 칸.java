import java.util.*;
class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        String color = board[h][w];
        int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int i=0; i<dir.length; i++) {
            int nr = dir[i][0] + h;
            int nc = dir[i][1] + w;
            if(nr >=0&& nr<board.length && nc >= 0 && nc < board[nr].length) {
                if(board[nr][nc].equals(color)) {
                    answer++;
                }
            }
        }
        return answer;
    }
}