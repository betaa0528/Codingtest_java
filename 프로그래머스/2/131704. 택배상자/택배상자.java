import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int cnt = 1;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i<order.length; i++) {
            
            for(; cnt<=order[i]; cnt++) {
                stack.push(cnt);
            }
            
            if(!stack.isEmpty() && stack.peek() == order[i]) {
                answer++;
                stack.pop();
            } else {
                break;
            }
        }
        return answer;
    }
}