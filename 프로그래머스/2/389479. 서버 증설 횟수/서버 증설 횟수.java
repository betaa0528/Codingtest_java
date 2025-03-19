import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int server = 0;
        Deque<int[]> q = new ArrayDeque<>();
        int cnt = 0;
        for(int player : players) {
            if(player / m > server) {
                cnt += player/m - server;
                q.add(new int[]{player/m - server, k});
                
                server += player / m - server;
                
            }
            int size = q.size();
            for(int j=0; j<size; j++) {
                int[] node = q.poll();
                node[1]--;
                if(node[1] > 0) {
                    q.add(node);
                } else {
                    server -= node[0];
                }
            }
        }
        return cnt;
    }
}