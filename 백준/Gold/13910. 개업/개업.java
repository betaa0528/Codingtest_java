import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        int answer = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] woks = new int[M];
        int[] dp = new int[N+1];
        int max = 100001;
        Arrays.fill(dp, max);
        for(int i = 0; i < M; i++) {
            int wok = Integer.parseInt(st.nextToken());
            woks[i] = wok;
        }
        // 웍 하나
        for(int wok : woks) {
            if(wok > N) continue;
            dp[wok] = 1;
        }

        // 웍 두개
        for(int i = 0; i<woks.length; i++) {
            for(int j=i+1; j<woks.length; j++) {
                int sum = woks[i] + woks[j];
                if(sum <= N) {
                    dp[sum] = 1;
                }
            }
        }
        for(int i=1; i<=N; i++) {

            for(int j=0; j<=i/2; j++) {
                if(dp[j] >= max) continue;
                dp[i] = Math.min(dp[i], dp[i-j] + dp[j]);
            }
        }
        System.out.println(dp[N] >= max ? -1 : dp[N]);
    }


}
