import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int cnt = 1;
        Stack<Integer> stack = new Stack<>();
        while(len-- > 0) {
            int num = sc.nextInt();
            if (num == cnt) {
                cnt++;
            } else if (!stack.isEmpty()) {
                while (!stack.isEmpty()) {
                    if (cnt == stack.peek()) {
                        stack.pop();
                        cnt++;
                    } else {
                        break;
                    }
                }
                stack.push(num);
            } else {
                stack.push(num);
            }
        }
        while(!stack.isEmpty()) {
            if(cnt == stack.peek()) {
                stack.pop();
                cnt++;
            } else {
                break;
            }
        }
        if (stack.isEmpty()) System.out.println("Nice");
        else System.out.println("Sad");
    }
}