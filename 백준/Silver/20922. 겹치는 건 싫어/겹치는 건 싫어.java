import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        int answer = 0;
        while(st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
            queue.addLast(num);
            if(map.get(num) > k) {
                while(true) {
                    int poll = queue.pollFirst();
                    map.put(poll, map.get(poll) - 1); 
                    if(poll == num) {
                        break;
                    }
                }
            }
            answer = Math.max(answer, queue.size());
        }
        System.out.println(answer);
    }
}