import java.util.*;
class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
    
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            list.add(new ArrayList<>());
        }
        
        for(int[] road : roads) {
            int s = road[0];
            int e = road[1];
            list.get(s).add(e);
            list.get(e).add(s);
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        int[] visited = new int[n+1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[destination] = 0;
        int[] s = {destination, 0};
        djikstra(list, visited, s);
        int[] answer = new int[sources.length];
        for(int i=0; i<sources.length; i++) {
            if(visited[sources[i]] == Integer.MAX_VALUE) answer[i] = -1;
            else answer[i] = visited[sources[i]];
        }
        return answer;
    }
    
    public static void djikstra(List<List<Integer>> list, int[] visited, int[] s) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(s);
        while(!q.isEmpty()) {
            int[] node = q.poll();
            
            for(int edge : list.get(node[0])) {
                int cost = node[1] + 1;
                if(cost < visited[edge]) {
                    visited[edge] = cost;
                    q.add(new int[]{edge, cost});
                }
            }
        }
    }
}