import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(br.readLine());
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int i=1; i<=V; i++) {
            graph.put(i, new ArrayList<>());
        }
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new int[]{v,w});
        }

        int INF = Integer.MAX_VALUE;
        int[] visit = new int[V+1];
        Arrays.fill(visit, INF);
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[]{s, 0});
        visit[s] = 0;
        while(!pq.isEmpty()) {
            int[] edge = pq.poll();
            for(int[] node : graph.get(edge[0])){
                int dist = node[1] + edge[1];
                if(visit[node[0]] > dist) {
                    pq.add(new int[]{node[0], dist});
                    visit[node[0]] = dist;
                }
            }
        }

        for(int i=1; i<=V; i++) {
            System.out.println(visit[i] == INF ? "INF" : visit[i]);
        }

    }
}
