import java.util.*;
class Solution {
    public static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0 ,-1}};
    public static boolean[][] visit;
    public static int[][] nums;
    public static Map<Integer, Integer> dp = new HashMap<>();
    public int solution(int[][] land) {
        int answer = 0;
        nums = new int[land.length][land[0].length];
        visit = new boolean[land.length][land[0].length];
        dp.put(0, 0);
        int no = 1;
        for(int i=0; i<land.length; i++) {
            for(int j=0; j<land[0].length; j++) {
                if(!visit[i][j] && land[i][j] != 0) {
                    int cnt =0;
                    List<int[]> list = new ArrayList<>();
                    cnt = bfs(new int[]{i,j}, land, list);
                    write(list, no, cnt);
                    no++;
                }
            }
        }
        for(int i=0; i<land[0].length; i++) {
            Set<Integer> set  =new HashSet<>();
            int result = 0;
            for(int j=0; j<land.length; j++){
                set.add(nums[j][i]);
            }
            for(int n : set) {
                result += dp.get(n);
            }
            answer = Math.max(result, answer);
        }
        return answer;
    
        
    }
    
    public static void write(List<int[]> list, int no, int cnt) {
        for(int[] d : list) {
            nums[d[0]][d[1]] = no;
        }
        
        dp.put(no, cnt);
        
        
    }
    
    public static int bfs(int[] s, int[][] land, List<int[]> list) {
        int cnt = 1;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(s);
        list.add(s);
        visit[s[0]][s[1]] = true;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for(int i=0; i<4; i++) {
                int nr = cur[0] + dir[i][0];
                int nc = cur[1] + dir[i][1];
                if(nr < 0 || nr >= land.length || nc < 0 || nc >= land[0].length) {
                    continue;
                }
                
                if(visit[nr][nc] || land[nr][nc] == 0) {
                    continue;
                }
                int[] oil = new int[]{nr, nc};
                queue.add(oil);
                list.add(oil);
                visit[nr][nc] = true;
                cnt++;
                
            }
        }
        return cnt;
    }
} 