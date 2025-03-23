import java.util.*;
class Solution {
    public int solution(int[][] points, int[][] routes) {
        Map<String, Integer> map = new HashMap<>();


        int answer = 0; 

        for (int[] route : routes) {
            int time = 0;
            int[] now = points[route[0] - 1]; 
            String key = now[0] + "," + now[1] + "," + time;
            map.put(key, map.getOrDefault(key, 0) + 1);

            for (int i = 1; i < route.length; i++) {
                int[] next = points[route[i] - 1];
                time = move(next, now, map, time);
                now = next; 
            }
        }

        
        for(int time : map.values()) {
            if(time >= 2) answer++;
        }

        return answer;
    }

    public static int move(int[] goal, int[] now, Map<String, Integer> map, int time) {
        int r = now[0], c = now[1];

        while (r != goal[0]) {
            r += (goal[0] > r) ? 1 : -1; 
            ++time;
            String key = r + "," + c + "," + time;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        while (c != goal[1]) {
            c += (goal[1] > c) ? 1 : -1; 
            ++time;
            String key = r + "," + c + "," + time;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return time;
    }
}
