import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
//        st = new StringTokenizer(br.readLine());
        Scanner sc = new Scanner(System.in);
        char[] arr = br.readLine().toCharArray();
        String bomb = br.readLine();
        int bombSize = bomb.length();
        boolean flag = true;
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
            flag = true;
            if(stack.size() >= bombSize) {
                for(int j=0; j<bombSize; j++) {
                    if(stack.get(stack.size()-bombSize+j) != bomb.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    for(int k=0; k<bombSize; k++) {
                        stack.pop();
                    }
                }
            }
        }

        sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        System.out.println(sb.length() == 0? "FRULA" : sb.toString());
    }

}