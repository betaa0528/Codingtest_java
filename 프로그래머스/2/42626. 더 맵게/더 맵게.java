import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int cnt = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int s : scoville) {
            pq.add((long)s);
        }
        while(pq.size() > 1) {
            if(pq.peek() >= K) {
                break;
            }
            long result = pq.poll() + pq.poll() * 2;
            cnt++;
            pq.add(result);
            
        }
        return pq.peek() < K ? -1 : cnt;
    }
}