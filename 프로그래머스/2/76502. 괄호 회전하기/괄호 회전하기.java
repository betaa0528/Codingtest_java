import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("(", ")");
        hashMap.put("{", "}");
        hashMap.put("[", "]");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            int reset = 0;
            while (reset < s.length()) {
                if (!stack.isEmpty() && hashMap.get(stack.peek())!=null&& hashMap.get(stack.peek()).equals(String.valueOf(s.charAt((i + reset) % s.length())))) {
                    stack.pop();
                } else {
                    stack.push(String.valueOf(s.charAt((i + reset) % s.length())));
                }
                reset++;
            }
            if (stack.isEmpty()) {
                answer++;
            } else {
                stack.clear();
            }
        }

        return answer;
    }
}