import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        boolean[] visit = new boolean[200001];
        visit[s] = true;
        Deque<int[]> queue = new ArrayDeque<>();
        int[] answer = new int[300001];

        queue.add(new int[]{s, 0});
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            if(node[0] == e) {
                System.out.println(node[1]);
                int[] ans = new int[node[1] + 1];
                int tmp = e;
                int idx = node[1]-1;
                ans[0] = s;
                ans[node[1]] = e;
                while(idx >= 0 && answer[tmp] != s) {
                    ans[idx--] = answer[tmp];
                    tmp = answer[tmp];
                }

                for(int a : ans) {
                    System.out.print(a + " ");
                }
                break;
            }
            for(int i=0; i<3; i++) {
                int now = node[0];
                if(i == 0) {
                    now--;
                } else if(i == 1) {
                    now++;
                } else {
                    now *= 2;
                }

                if(now < 0 || now > 100000 || visit[now]) {
                    continue;
                }
                answer[now] = node[0];
                queue.add(new int[]{now, node[1] + 1});
                visit[now] = true;
            }
        }
    }
}
