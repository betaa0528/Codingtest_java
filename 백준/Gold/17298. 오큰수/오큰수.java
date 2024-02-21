import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
//        st = new StringTokenizer(br.readLine());
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> com = new Stack<>();
        int[] nge = new int[N];
        int cnt = 0;
        while (st.hasMoreTokens()) {
            stack.push(Integer.parseInt(st.nextToken()));
        }

        for(int j=N-1; j>=0; j--) {
            if(com.isEmpty()) {
                com.push(stack.pop());
                nge[j] = -1;
            } else {
                if(com.peek() > stack.peek()) {
                    nge[j] = com.peek();
                } else {
                    while(!com.isEmpty() && stack.peek() >= com.peek()){
                        com.pop();
                    }
                    if(com.isEmpty()) {
                        nge[j] = -1;

                    } else {
                        nge[j] = com.peek();
                    }
                }
                com.push(stack.pop());
            }
        }
        for(int n : nge) {
            bw.write(n + " ");
        }
        bw.flush();
        bw.close();

    }
}