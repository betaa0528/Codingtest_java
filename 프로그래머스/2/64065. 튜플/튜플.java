import java.util.*;
class Solution {
    public int[] solution(String s) {
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        Map<Integer, Integer> map = new HashMap<>();
        s = s.replace("{", "");
        s = s.replace("}", "");
        String[] arr = s.split(",");
        for(String a : arr) {
            int num = Integer.parseInt(a);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int key : map.keySet()) {
            pq.add(new int[]{key, map.get(key)});
        }
        int[] answer = new int[pq.size()];
        int idx = 0;
        while(!pq.isEmpty()) {
            answer[idx++] = pq.poll()[0];
        }
        return answer;
    }
}