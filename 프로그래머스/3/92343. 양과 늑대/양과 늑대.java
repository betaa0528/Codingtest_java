class Solution {
    public int solution(int[] info, int[][] edges) {
        int answer = 1;
        boolean[] visit = new boolean[info.length];
        visit[0] = true;

        answer = backtracking(info, edges, visit, 1, 0);
        return answer;
    }
    
    public static int backtracking(int[] info, int[][] edges, boolean[] visit, int sheep, int wolf) {
        if(sheep == wolf) return sheep;
        int maxSheep = sheep;
        
        for(int[] edge : edges) {
            int p = edge[0];
            int c = edge[1];
            if(!visit[p] || visit[c]) continue;
            visit[c] = true;
            if(info[c] == 1) {
                maxSheep = Math.max(backtracking(info, edges, visit, sheep, wolf+1), maxSheep);
            } else {
                maxSheep = Math.max(backtracking(info, edges, visit, sheep+1, wolf), maxSheep);
            }
            visit[c] = false;
        }
        
        return maxSheep;
    }
}
