import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        Deque<Integer> q = new ArrayDeque<>();
        q.push(0);
        for(int i=1; i<numbers.length; i++) {
            while(!q.isEmpty() && numbers[q.peek()] < numbers[i]) {
                numbers[q.pop()] = numbers[i];
            }
            q.push(i);
        }
        while(!q.isEmpty()) {
            numbers[q.pop()] = -1;
        }
        return numbers;
    }
}