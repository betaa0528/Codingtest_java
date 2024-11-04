import java.util.*;
class Solution {
    public static int[][] dir = {{1,0}, {-1, 0}, {0,1}, {0,-1}};
    public int[] solution(String[] maps) {
        boolean[][] visit = new boolean[maps.length][maps[0].length()];
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[i].length(); j++) {
                if(maps[i].charAt(j) != 'X' && !visit[i][j]){
                    int result = bfs(maps, new int[]{i, j}, visit);
                    list.add(result);
                }
            }
        }
        if(list.size() > 0) {
            int[] answer = new int[list.size()];
            for(int i=0; i<list.size(); i++) {
                answer[i] = list.get(i);
            }
            Arrays.sort(answer);
            return answer;
        }
        return new int[]{-1};
    }
    
    public static int bfs(String[] maps, int[] s, boolean[][] visit) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(s);
        visit[s[0]][s[1]] = true;
        int sum = Integer.parseInt(maps[s[0]].charAt(s[1]) + "");
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            for(int i=0; i<dir.length; i++) {
                int nr = node[0] + dir[i][0];
                int nc = node[1] + dir[i][1];
                if(nr < 0 || nr >= maps.length || nc < 0 || nc >= maps[nr].length() || visit[nr][nc] || maps[nr].charAt(nc) == 'X') {
                    continue;
                }
                queue.add(new int[]{nr, nc});
                visit[nr][nc] = true;
                sum += Integer.parseInt(maps[nr].charAt(nc) + "");
            }
        }
        return sum;
    }
}