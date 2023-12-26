import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        while(size --> 0) {
            String command = br.readLine();
            if(command.length() > 1) {
                stack.push(Integer.parseInt(command.split(" ")[1]));
            }

            switch (command) {
                case "2":
                    bw.write(stack.isEmpty() ? -1 + "\n" : stack.pop() + "\n");
                    break;
                case "3":
                    bw.write(stack.size() + "\n");
                    break;
                case "4":
                    bw.write(stack.isEmpty() ? 1 + "\n" : 0 + "\n");
                    break;
                case "5":
                    bw.write(stack.isEmpty() ? -1 + "\n" : stack.peek() + "\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}