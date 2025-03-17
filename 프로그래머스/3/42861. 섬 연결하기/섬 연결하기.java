import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        List<List<int[]>> list = new ArrayList<>();
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        for(int i=0; i<n; i++) {
            list.add(new ArrayList<>());
        }
        
        for(int[] cost : costs) {
            int s = cost[0];
            int e = cost[1];
            list.get(s).add(new int[]{e, cost[2]});
            list.get(e).add(new int[]{s, cost[2]});
        }
        
        int[] parents = new int[n];
        Arrays.fill(parents, -1);
        int[] visit = new int[n];
        Arrays.fill(visit, Integer.MAX_VALUE);
        
        for(int[] edge : list.get(0)) {
            pq.add(edge);
        }
        visit[0] = 0;
        int cnt = 0;
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            if(visit[now[0]] == 0) continue;
            visit[now[0]] = 0;
            cnt += now[1];
            for(int[] node : list.get(now[0])) {
                if(visit[node[0]] == 0) {
                    continue;
                }
                pq.add(node);
            }
        }
        // System.out.println(Arrays.toString(visit));
        // int answer = 0;
        // for(int i=0; i<visit.length; i++) {
        //     answer += visit[i];
        // }
        return cnt;
    }
}