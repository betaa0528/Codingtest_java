import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int answer = 0;
        int[] arr = new int[100001];
        int[] visit = new int[100001];

        Deque<int[]> queue = new ArrayDeque<>();
        int[] start = {n, 0};
        queue.add(start);
        visit[start[0]] = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if(cur[0] == k) {
                answer = cur[1];
                break;
            }
            for(int i=0; i<3; i++) {
                int nx = change(cur[0], i);
                int time = cur[1];
                if(nx < 0 || nx >= 100001 || visit[nx] == 1) {
                    continue;
                }
                queue.add(new int[]{nx, time+1});
                visit[nx] = 1;
            }
        }
        System.out.println(answer);
    }
    public static int change(int n, int i) {
        if(i == 0) {
            return n-1;
        } else if(i == 1) {
            return n+1;
        } else {
            return n*2;
        }
    }
}

