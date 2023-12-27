import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
            String str = br.readLine();
            if(str.equals(".")) {
                break;
            }
            solution(str);
        }
    }
    public static void solution(String str) {
        Stack<String> stack = new Stack<>();
        String[] strArr = str.split("");
        for(String s : strArr) {
            if(s.equals("(") || s.equals("[")) {
                stack.push(s);
            } else if(s.equals(")") || s.equals("]")) {
                if(!stack.isEmpty()) {
                    if(s.equals(")") && stack.peek().equals("(")) {
                        stack.pop();
                    } else if(s.equals("]") && stack.peek().equals("[")){
                        stack.pop();
                    } else {
                        stack.push(s);
                    }
                } else {
                    stack.push(s);
                }
            }
        }
        if(stack.isEmpty()) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}