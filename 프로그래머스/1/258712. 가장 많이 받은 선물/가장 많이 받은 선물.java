import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        Map<String,Integer> map = new HashMap<>();
        Map<Integer, String> name = new HashMap<>();
        int len = friends.length;
        int[][] board = new int[len][len];
        int idx = 0;
        for(String friend : friends) {
            map.put(friend, idx++);
            name.put(idx - 1, friend);
        }
        
        for(String gift : gifts) {
            String[] split = gift.split(" ");
            int sent = map.get(split[0]);
            int reciever = map.get(split[1]);
            board[sent][reciever]++;
        }
        int[][] index = new int[len][2];
        for(int i=0; i<len; i++) {
            int sum = 0;
            for(int j=0; j<len; j++) {
                sum += board[i][j];
            }
            index[i][0] = sum;
        }
        
        for(int j=0; j<len; j++) {
            int sum = 0;
            for(int i=0; i<len; i++) {
                sum += board[i][j];
            }
            index[j][1] = sum;
        }
        
        for(int i=0; i<len; i++) {
            int add = 0;
            for(int j=0; j<len; j++) {
                if(i==j) continue;
                if(board[i][j] > board[j][i]) {
                    add++;
                }
                if(board[i][j] == board[j][i] || board[i][j] == 0 && board[j][i] == 0) {
                    int sPoint = index[i][0] - index[i][1];
                    int rPoint = index[j][0] - index[j][1];
                    if(sPoint > rPoint) {
                        add++;
                    }
                }
            }
            answer = Math.max(add, answer);
        }
        
        
        return answer;
    }
}