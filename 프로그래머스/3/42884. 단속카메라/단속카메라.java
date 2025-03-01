import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        Queue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[0] - o2[0]);
        Deque<int[]> stack = new ArrayDeque<>();
        for(int[] route: routes) {
            pq.add(route);
        }
        stack.push(pq.poll());
        while(!pq.isEmpty()) {
            int[] car = pq.poll();
            if(stack.peek()[1] >= car[0]) {
                int[] pre = stack.pop();
                int[] now = {car[0], Math.min(car[1], pre[1])};
                stack.push(now);
            } else {
                stack.push(car);
            }
        }
        
        return stack.size();
    }
}