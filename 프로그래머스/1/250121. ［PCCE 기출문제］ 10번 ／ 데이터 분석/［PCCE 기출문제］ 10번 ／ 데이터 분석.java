import java.util.*;
class Solution {
    static Queue<int[]> pq;
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int idx = -1;
        if(ext.equals("code")) {
            idx = 0;
        } else if(ext.equals("date")) {
            idx = 1;
        } else if(ext.equals("maximum")) {
            idx = 2;
        } else {
            idx = 3;
        }
        
        if(sort_by.equals("code")) {
            pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        } else if(sort_by.equals("date")) {
            pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        } else if(sort_by.equals("maximum")) {
            pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        } else {
            pq = new PriorityQueue<>((o1, o2) -> o1[3] - o2[3]);
        }
        for(int[] d : data) {
            if(d[idx] < val_ext) {
                pq.add(d);
            }
        }
        
        int[][] answer = new int[pq.size()][2];
        int cnt = 0;
        while(!pq.isEmpty()) {
            answer[cnt++] = pq.poll();
        }
        return answer;
    }
}