import java.util.*;

class Solution {
    public static int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                dfs(computers, i);
                answer++;
            }
        }
//         Map<Integer, List<int[]>> map = new HashMap<>();
//         for(int i=1; i<=n; i++) {
//             map.put(i, new ArrayList<>());
//         }
        
//         for(int i=0; i<n; i++) {
//             int u = computers[i][0];
//             int v = computers[i][1];
//             int w = computers[i][2];
//             map.get(u).add(new int[]{v,w});
//             map.get(v).add(new int[]{u,w});
//         }
        return answer;
    }
    
    public static void dfs(int[][] computers, int start) {
        for(int i=0; i<computers.length; i++) {
            if(start != i && !visited[i]) {
                if(computers[start][i] == 1){
                    visited[i] = true;
                    dfs(computers, i);    
                }
            }
        }
        
    }
}