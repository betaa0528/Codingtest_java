import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int[] visit = new int[N+1];
        Arrays.fill(visit, Integer.MAX_VALUE);
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] r : road) {
            int s = r[0];
            int e = r[1];
            int w = r[2];
            graph.get(s).add(new int[]{e, w});
            graph.get(e).add(new int[]{s, w});
        }
        
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[]{1,0});
        visit[1] = 0;
        while(!pq.isEmpty()) {
            int[] node = pq.poll();
            for(int[] edge : graph.get(node[0])) {
                int dist = edge[1] + node[1];
                if(dist < visit[edge[0]]) {
                    pq.add(new int[]{edge[0], dist});
                    visit[edge[0]] = dist;
                }
            }
        }
        int answer = 0;
        for(int num : visit) {
            answer = num <= K ? answer+1 : answer;
        }
        
        return answer;
    }
}