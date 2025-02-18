import java.util.*;
class Solution {
    public String solution(String number, int k) {
        
        Deque<Character> q = new ArrayDeque<>();
        q.addLast(number.charAt(0));
        for(int i=1; i<number.length(); i++) {
            char c = number.charAt(i);
            while(!q.isEmpty() && c > q.peekLast() && k > 0) {
                k--;
                q.pollLast();
            }
            q.addLast(c);
        }
        while(k > 0) {
            q.pollLast();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            sb.append(q.pollFirst());
        }
        return sb.toString();
    }
}