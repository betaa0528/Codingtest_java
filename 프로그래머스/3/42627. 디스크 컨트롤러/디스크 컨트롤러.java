import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int sum = 0;
        int answer = 0;
        Arrays.sort(jobs, (o1, o2) -> {
            int result = o1[0] - o2[0];
            if(result == 0) {
                result = o1[1] - o2[1];
            }
            return result;
        });
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            int result = o1[1] - o2[1];
            if( result == 0) {
                result = o1[0] - o2[0];
            }
            return result;
        });
        pq.add(jobs[0]);
        int idx = 1;
        while(!pq.isEmpty() || idx < jobs.length) {
            if(!pq.isEmpty()) {
                int[] cur = pq.remove();
                
                if(cur[0] > sum) {
                    sum = cur[0] - sum;
                }
                
                          
                sum += cur[1];
                answer += (sum - cur[0]);
                while(idx < jobs.length && jobs[idx][0] <= sum) {
                    pq.add(jobs[idx++]);
                }
            } else if(pq.isEmpty()) {
                sum = Math.max(sum, jobs[idx][0]);
                pq.add(jobs[idx++]);
            }
  
            // System.out.println((sum - cur[0]) +  "(=" + sum + " - " + cur[0] + ")");
            
        }
        return answer / jobs.length;
    }
}