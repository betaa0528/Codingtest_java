import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[] dir = {u, -d};
        int answer = -1;
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{s, 0});
        boolean[] visit = new boolean[f+1];
        while(!q.isEmpty()) {
            int[] now = q.poll();
            if(now[0] == g) {
                answer = now[1];
            }
            for (int i = 0; i < dir.length; i++) {
                int nr = now[0] + dir[i];
                if (nr > f || nr <= 0 || visit[nr]) {
                    continue;
                }
                visit[nr] = true;
                q.add(new int[]{nr, now[1] + 1});
            }
        }
        System.out.println(answer == -1 ? "use the stairs" : answer);
    }
}
