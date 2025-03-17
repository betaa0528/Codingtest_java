import java.util.*;
class Solution {
    public static Queue<Integer> pq;
    public int solution(int[] cards) {
        int answer = 0;
        int boxCnt = cards.length;
        pq = new PriorityQueue<>(Comparator.reverseOrder());
        int[] box = new int[2];
        int cnt = 0;
        for(int i=0; i<cards.length; i++) {
            if(cards[i] != 0) {
                int result = search(cards, i);
                pq.add(result);
                cnt++;
                boxCnt -= result;
                if(cnt == 1 && boxCnt == 0) return 0; 
            }
        }
        answer = pq.poll() * pq.poll();
        return answer;
    }
    
    public static int search(int[] cards, int s) {
        int idx = cards[s] - 1;
        int result = 1;
        cards[s] = 0;
        while(cards[idx] != 0) {
            int tmp = cards[idx] - 1;
            cards[idx] = 0;
            idx = tmp;
            result++;
        }
        
        return result;
    }
}