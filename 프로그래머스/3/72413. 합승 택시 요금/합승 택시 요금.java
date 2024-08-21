import java.util.*;
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        int answer = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int i=0; i<fares.length; i++) {
            int u = fares[i][0];
            int v = fares[i][1];
            int w = fares[i][2];
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }

        int[] result1 = dijkstra(graph, n, s);
        int[] result2 = dijkstra(graph, n, a);
        int[] result3 = dijkstra(graph, n, b);
        for(int i=1; i<=n; i++) {
            answer = Math.min(result1[i] + result2[i] + result3[i], answer);
        }
        return answer;
    }
    
    public static int[] dijkstra(Map<Integer, List<Edge>> graph,int n, int s) {
        int[] visited = new int[n+1];
        Queue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Edge(s, 0));
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[s] = 0;
        while(!pq.isEmpty()) {
            Edge cur = pq.remove();
            if (cur.cost > visited[cur.node]) {
                continue;
            }
            for (Edge edge : graph.get(cur.node)) {
                int dist = cur.cost + edge.cost;
                if(dist < visited[edge.node]) {
                    visited[edge.node] = dist;
                    pq.add(new Edge(edge.node, dist));
                }
            }
        }

        return visited;
    }

    static class Edge {
        int node;
        int cost;

        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
}