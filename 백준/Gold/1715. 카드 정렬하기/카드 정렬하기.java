import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> pq = new PriorityQueue<Integer>();
        for(int i=0; i<N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        while(pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            answer += a+b;
            pq.add(a+b);
        }
        System.out.println(answer);
    }
}
