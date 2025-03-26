import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        Map<String,Integer> map = new HashMap<>();
        int len = friends.length;
        
        int[][] board = new int[len][len];
        int[] index = new int[len];
        
        int idx = 0;
        for(String friend : friends) {
            map.put(friend, idx++);
        }
        
        for(String gift : gifts) {
            String[] split = gift.split(" ");
            
            index[map.get(split[0])]++;
            index[map.get(split[1])]--;
            board[map.get(split[0])][map.get(split[1])]++;
        }

        
        for(int i=0; i<len; i++) {
            int add = 0;
            for(int j=0; j<len; j++) {
                if(i==j) continue;
                if(board[i][j] > board[j][i]) {
                    add++;
                }
                if(board[i][j] == board[j][i] || board[i][j] == 0 && board[j][i] == 0) {
                    
                    if(index[i] > index[j]) {
                        add++;
                    }
                }
            }
            answer = Math.max(add, answer);
        }
        
        
        return answer;
    }
}