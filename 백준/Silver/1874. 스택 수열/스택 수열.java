import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        int max = 0;
        int chk = 0;
        Stack<Integer> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        while(tc --> 0) {
            int num = Integer.parseInt(br.readLine());
            if((stack.isEmpty() || stack.peek() < num) && chk != 1) {
                for(int i=max+1; i<=num; i++) {
                    stack.push(i);
                    list.add("+");
                }
                max = stack.peek();
            }

            if(num == stack.peek()) {
                stack.pop();
                list.add("-");
            } else {
                chk = 1;
                break;
            }
        }
        if(chk == 1) {
            System.out.println("NO");
        } else {
            for(String l : list) {
                System.out.println(l);
            }
        }
    }
}