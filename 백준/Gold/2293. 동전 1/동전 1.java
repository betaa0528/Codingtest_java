import java.util.*;
import java.io.*;
public class Main{
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());
        int[] coins = new int[count];
        int[] dp = new int[goal+1];
        for(int i=0; i<count; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coins);
        for(int coin : coins) {
            for(int j = coin; j<dp.length; j++) {
                if(j % coin == 0 && j <= coin) {
                    dp[j]++;
                } else {
                    dp[j] += dp[j-coin];
                }
            }
        }
        System.out.println(dp[goal]);
    }
}