import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> com = new Stack<>();
        int[] ngf = new int[N];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        while (st.hasMoreTokens()) {
            stack.push(Integer.parseInt(st.nextToken()));
            hashMap.put(stack.peek(), hashMap.getOrDefault(stack.peek(), 0) + 1);
        }

        for(int j=N-1; j>=0; j--) {
            if(com.isEmpty()) {
                com.push(stack.pop());
                ngf[j] = -1;
            } else {
                if(hashMap.get(com.peek()) > hashMap.get(stack.peek())) {
                    ngf[j] = com.peek();
                } else {
                    while(!com.isEmpty() && hashMap.get(stack.peek()) >= hashMap.get(com.peek()) ) {
                        com.pop();
                    }
                    if(com.isEmpty()) {
                        ngf[j] = -1;

                    } else {
                        ngf[j] = com.peek();
                    }
                }
                com.push(stack.pop());
            }
        }
        for(int n : ngf) {
            bw.write(n + " ");
        }
        bw.flush();
        bw.close();
    }
}