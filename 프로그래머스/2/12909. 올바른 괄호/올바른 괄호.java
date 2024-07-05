import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] charArray = s.toCharArray();
        for(char c : charArray) {
            if(!stack.isEmpty() && c == ')') {
                if(stack.peek() == '('){
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
        }
        return stack.isEmpty();
    }
}