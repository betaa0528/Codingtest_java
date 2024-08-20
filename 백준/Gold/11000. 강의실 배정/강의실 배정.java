import java.io.*;
import java.util.*;
class Main{
    public static void main(String[] args) throws IOException {
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] time = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            arr[i] = time;
        }
        Arrays.sort(arr, (o1, o2) -> {
            int result = o1[0] - o2[0];
            if (result == 0) {
                result = o1[1] - o2[1];
            }
            return result;
        });
        pq.offer(arr[0]);
        for (int i = 1; i < n; i++) {
            if (pq.peek()[1] <= arr[i][0]) {
                pq.poll();
            }
            pq.offer(arr[i]);
        }
        System.out.println(pq.size());
    }
}