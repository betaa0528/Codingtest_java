import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());


        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            while(!q.isEmpty() && q.peekLast()[0] > arr[i]) {
                q.pollLast();
            }
            q.add(new int[]{arr[i], i});

            if (i - q.peekFirst()[1] >= l) {
                q.poll();

            }

            bw.write(q.peekFirst()[0] + " ");
        }

        bw.flush();
        bw.close();

    }
}
