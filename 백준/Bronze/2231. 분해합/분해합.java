import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int start = 1;
        int cnt = 0;
        int sum = 0;

        if( N - 54 <= 0){
            cnt = start;
        } else {
            start = N - 54;
            cnt = start;
        }
        while (true) {
            sum += cnt % 10;
            cnt /= 10;
            if(cnt == 0) {
                if(start >= N) {
                    start = 0;
                    break;
                }
                if(sum + start == N) break;
                cnt = ++start;
                sum = 0;
            }
        }
        System.out.println(start);
    }
}