import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] visit = new boolean[n+1];
        queue.add(new int[]{1,0});
        visit[1] = true;
        int tmp = 0;
        int cnt = 0;
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            for(int vertex : graph.get(node[0])){
                if(!visit[vertex]) {
                    int idx = node[1] + 1;
                    if(idx > tmp) {
                        cnt = 0;
                        tmp = idx;
                    }
                    if(idx == tmp) cnt++;
                    queue.add(new int[]{vertex,idx});
                    visit[vertex] = true;
                }
            }
        }
        return cnt;
    }
}