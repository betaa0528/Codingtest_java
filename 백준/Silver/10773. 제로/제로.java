import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        while(len --> 0) {
            int money = Integer.parseInt(br.readLine());
            if(money == 0) {
                answer -= stack.pop();
            } else {
                stack.push(money);
                answer += money;
            }
        }
        System.out.println(answer);
    }
}