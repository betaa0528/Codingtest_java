import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            int result = o1[col-1] - o2[col-1];
            if(result == 0) {
                result = o2[0] - o1[0];
            }
            
            return result;
        });
        
        for(int[] d : data) {
            pq.add(d);
        }
        
        for(int i=0; i<row_end; i++) {
            int[] tmp = pq.poll();
            if(i < row_begin - 1) {
                continue;
            } else {
                int sum = 0;
                for(int num : tmp) {
                    sum += (num %(i+1));
                }
                answer ^= sum;
            }
        }
        return answer;
    }
}