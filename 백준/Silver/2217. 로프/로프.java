import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] rope = new int[10001];
        for(int i=0;i<N;i++) {
            rope[Integer.parseInt(br.readLine())]++;
        }
        int min = 0;
        int cnt = 0;
        int answer = 0;
        for(int i=10000; i>=0; i--) {
            if(rope[i] > 0) {
                min = i;
                cnt += rope[i];
                answer = Math.max(answer, min * cnt);
            }
        }
        System.out.println(answer);
    }
}
