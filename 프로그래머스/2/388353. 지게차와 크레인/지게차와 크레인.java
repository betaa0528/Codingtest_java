import java.util.*;
class Solution {
    public static int[][] dir = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
    public static int answer = 0;
    public int solution(String[] storage, String[] requests) {
        char[][] map = new char[storage.length][storage[0].length()];
        for(int i=0; i<storage.length; i++) {
            for(int j=0; j<storage[0].length(); j++) {
                map[i][j] = storage[i].charAt(j);
            }
        }
        for(String request : requests) {
            if(request.length() >1) {
                crain(map, request.charAt(0));
            } else {
                bfs(map, save(map, request.charAt(0)));
            }
        }
        return storage.length * storage[0].length() - answer;
    }
    
    public static void print(char[][] map) {
        for(char[] m : map) {
            System.out.println(Arrays.toString(m));
        }
    }
    
    public static Deque<int[]> save(char[][] map, char c) {
        Deque<int[]> q = new ArrayDeque<>();
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[0].length; j++) {
                if(map[i][j] == c) {
                    q.add(new int[]{i, j});
                }
            }
        }
        return q;
    }
    
    public static void crain(char[][] map, char c) {
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[0].length; j++) {
                if(map[i][j] == c) {
                    map[i][j] = '!';
                    answer++;
                }
            }
        }
    }
    
    public static void bfs(char[][] map, Deque<int[]> q) {
        Deque<int[]> delete = new ArrayDeque<>();
        while(!q.isEmpty()) {
            int[] node = q.poll();
            for(int i=0; i<dir.length; i++) {
                int nr = dir[i][0] + node[0];
                int nc = dir[i][1] + node[1];
       
                if(nr < 0 || nr >= map.length || nc < 0 || nc >= map[0].length) {
                    answer++;
                    delete.add(node);
                    break;
                }
                
                if(map[nr][nc] == '!') {
                    if(check(map, new int[]{nr, nc})) {
                        answer++;
                        delete.add(node);
                        break;
                    }
                }
            }
        }
        
        while(!delete.isEmpty()) {
            
            int[] node = delete.poll();
            map[node[0]][node[1]] = '!';
        }
    }
    
    public static boolean check(char[][] map, int[] node) {
        
        Deque<int[]> q = new ArrayDeque<>();
        q.add(node);
        boolean[][] visited = new boolean[map.length][map[0].length];
        visited[node[0]][node[1]] = true;
        while(!q.isEmpty()) {
            int[] n = q.poll();
            for(int i=0; i<dir.length; i++) {
                int nr = n[0] + dir[i][0];
                int nc = n[1] + dir[i][1];
                
                if(nr < 0 || nr >= map.length || nc < 0 || nc >= map[0].length) {
                    return true;
                }
                if(visited[nr][nc]) {
                    continue;
                }
                if(map[nr][nc] == '!') {
                    q.add(new int[]{nr, nc});
                }
                visited[nr][nc] = true;
            }
        }
        
        return false;
    }
}