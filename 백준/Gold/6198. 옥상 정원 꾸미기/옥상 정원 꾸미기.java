import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        long answer = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (stack.isEmpty()) {
                stack.push(num);
                max = num;
                continue;
            }

            if (max > num) {
                while (!stack.isEmpty() && stack.peek() <= num) {
                    stack.pop();
                }
                answer += stack.size() * 1;
                stack.push(num);
            } else {
                while (!stack.isEmpty()) {
                    stack.pop();
                }
                stack.push(num);
                max = num;
            }

        }
        System.out.println(answer);
    }
}
