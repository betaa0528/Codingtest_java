import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[n];
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }

            if (arr[stack.peek()] >= arr[i]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                    int idx = stack.pop();
                    answer[idx] = arr[i];

                }
                stack.push(i);
            }
        }

        while(!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        for(int ans : answer) {
            bw.write(ans + " ");
        }
        bw.flush();
        bw.close();
    }
}