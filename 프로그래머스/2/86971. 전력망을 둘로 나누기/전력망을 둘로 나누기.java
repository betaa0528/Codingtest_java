import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<wires.length; i++) {
            int u = wires[i][0];
            int v = wires[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        for(int i=0; i<wires.length; i++) {
            int result = n - 2 * Math.min( bfs(graph, 1, new boolean[n+1], wires[i][1]) , bfs(graph, 1, new boolean[n+1], wires[i][0]));
            System.out.println();
            // System.out.println(j + ", " + wires[i][1] + " , " + result);
            answer = Math.min(result < 0? result*-1:result, answer);
        }
        return answer;
    }
    
    public static int bfs(List<List<Integer>> graph, int start, boolean[] visit, int x) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(start);
        visit[start] = true;
        int cnt = 1;
        while(!queue.isEmpty()) {
            int cur = queue.pollFirst();
            for(int node : graph.get(cur)) {
                if(node == x) {
                    continue;
                }
                if(!visit[node]) {
                    queue.addLast(node);
                    visit[node] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}