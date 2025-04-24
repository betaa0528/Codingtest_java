import java.util.*;
class Solution {
    public static int[] answer;
    public static int idx;
    public static Deque<Integer> q;
    public static Deque<int[]> rcq;
    public int[] solution(int rows, int columns, int[][] queries) {
        answer = new int[queries.length];
        idx = 0;
        int[][] map = new int[rows][columns];
        int val = 1;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                map[i][j] = val++;
            }
        }
        
        for(int[] query : queries) {
            save(map, query);
            write(map);
        }
        return answer;
    }
    
    public static void write(int[][] map) {
        int min = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            int[] node = rcq.poll();
            int val = q.poll();
            map[node[0]][node[1]] = val;
            min = Math.min(val, min);
        }
        answer[idx++] = min;
    }
    
    // 값들을 저장
    public static void save(int[][] map, int[] query) {
        int sr = query[0] - 1;
        int sc = query[1] - 1;
        int er = query[2] - 1;
        int ec = query[3] - 1;
        q = new ArrayDeque<>();
        rcq = new ArrayDeque<>();
        int[][] dir = {{0,1}, {1,0}, {0, -1}, {-1,0}};
        int d = 0;
        int nr = sr;
        int nc = sc;
        q.add(map[nr][nc]);
        rcq.add(new int[]{nr, nc});
        while(d<4) {
            nr += dir[d][0];
            nc += dir[d][1] ;
            if(nr > er || nc > ec || nr < sr || nc < sc) {
                nr -= dir[d][0];
                nc -= dir[d][1];
                d++;
                continue;
            }
            q.add(map[nr][nc]);
            rcq.add(new int[]{nr, nc});
        }
        q.pollLast();
        rcq.pollLast();
        q.addFirst(q.pollLast());
        
//         System.out.println(q);
//         System.out.println(rcq.size());
//         System.out.println(q.size());
    }
}