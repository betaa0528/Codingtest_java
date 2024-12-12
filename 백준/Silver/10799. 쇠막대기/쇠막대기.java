import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> stack = new ArrayDeque<>();
        String str = br.readLine();
        int answer = 0;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '(') {
                stack.push(i);
            } else {
                if(str.charAt(stack.peek()) == '(') {
                    if(i - stack.peek() == 1) {
                        stack.pop();
                        answer += stack.size();
                    } else {
                        answer++;
                        stack.pop();
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
