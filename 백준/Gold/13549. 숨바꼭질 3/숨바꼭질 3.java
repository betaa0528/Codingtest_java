import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[200001];
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));
        pq.add(new int[]{s, 0});
        visited[s] = true;
        int[] dir = {-1, 1, 2};
        while(!pq.isEmpty()) {
            int[] node = pq.poll();
            visited[node[0]] = true;
            if(node[0] == e) {
                System.out.println(node[1]);
                break;
            }
            int now = 0;
            for(int i=0; i<dir.length; i++) {
                if(dir[i] == 2) {
                    now = node[0] * 2;
                } else {
                    now = node[0] + dir[i];
                }
                if(now < 0 || now > 100001 || visited[now]) {
                    continue;
                }

                if(i == 2) {
                    pq.add(new int[]{now, node[1]});
                } else {
                    pq.add(new int[]{now, node[1] + 1});
                }
            }
        }
    }
}
