import java.util.*;
class Solution {
    public static List<int[]> list = new ArrayList<>();
    public int[][] solution(int n) {
        hanoi(n, 1,3, 2);
        int[][] answer = new int[list.size()][2];
        for(int i =0 ; i<list.size(); i++) {
            int[] node = list.get(i);
            answer[i][0] = node[0];
            answer[i][1] = node[1];
        }
        return answer;
    }
    
    public static void hanoi(int n, int from, int to, int via) {
        if(n == 1) {
            list.add(new int[]{from, to});
            return; 
        }
        hanoi(n-1, from, via, to);
        hanoi(1, from, to, via);
        hanoi(n-1, via, to, from);
    }
    
}