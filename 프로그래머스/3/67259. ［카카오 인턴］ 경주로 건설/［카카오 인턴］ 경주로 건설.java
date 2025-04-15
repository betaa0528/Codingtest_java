import java.util.*;
class Solution {
    static class Node {
        int r;
        int c;
        int dir;
        int cost;
        
        public Node() {}
        public Node(int r, int c, int dir, int cost) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.cost = cost;
        }
    
    }
    // 상 하 좌 우 0 1 2 3
    public static int[][] dir = {{-1,0}, {1, 0}, {0,-1}, {0,1}};
    public int solution(int[][] board) {

        return bfs(new int[]{0,0}, board.length, board.length, board);
    }
    
    public static int bfs(int[] s, int r, int c, int[][] map) {
        Deque<Node> q = new ArrayDeque<>();
        int[][][] visited = new int[r][c][4];
        
        for(int[][] visit : visited) {
            for(int[] v : visit) Arrays.fill(v, Integer.MAX_VALUE);
        }
        for(int i=0; i<dir.length; i++) {
            q.add(new Node(0, 0, i, 0));
            visited[0][0][i] = 0;
        }
        while(!q.isEmpty()) {
            Node node = q.poll();
            
            for(int i=0; i<dir.length; i++) {
                int nr = node.r + dir[i][0];
                int nc = node.c + dir[i][1];
                
                if(nr < 0 || nr >= r || nc < 0 || nc >= c || map[nr][nc] == 1) continue;
                
                int cost = node.cost + (node.dir != i ? 600 : 100);
                
                if(visited[nr][nc][i] > cost) {
                    Node newNode = new Node(nr, nc, i, cost);
                    q.add(newNode);
                    visited[nr][nc][i] = cost;
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for(int i=0; i<4; i++) {
            answer = Math.min(visited[r-1][c-1][i], answer);
        }
        return answer;
    }
}