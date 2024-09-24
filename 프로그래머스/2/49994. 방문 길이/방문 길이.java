import java.util.*;
class Solution {
    public int solution(String dirs) {
        Set<String> set = new HashSet<>();
        int answer = 0;
        // int[][] visit = new int[11][11];
        int[] cursor = {5,5};
        for(int i=0; i<dirs.length(); i++) {
            int nr = cursor[0];
            int nc = cursor[1];
            char dir = dirs.charAt(i);
            if(dir == 'U') {
                nr--;
            } else if(dir == 'D') {
                nr++;
            } else if(dir == 'R') {
                nc++;
            } else {
                nc--;
            }
            
            if(nr < 0 || nr >= 11 || nc < 0 || nc >= 11) {
                continue;
            }
            String way1 = "" + cursor[0] + cursor[1] + nr + nc;
            String way2 = "" + nr + nc + cursor[0] + cursor[1];
            if(!set.contains(way1) && !set.contains(way2)) {
                answer++;
                set.add(way1);
                set.add(way2);
            }
            
            cursor = new int[] {nr, nc};
        }
        return answer;
    }
}