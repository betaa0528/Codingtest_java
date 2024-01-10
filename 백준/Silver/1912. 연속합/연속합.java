import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int len = Integer.parseInt(br.readLine());
        int[] nums = new int[len];
        int[] dp = new int[len];
        int max = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            if (i == 0) {
                dp[i] = nums[i];
            } else {
                if (dp[i - 1] <= 0) {
                    dp[i] = nums[i];
                } else {
                    dp[i] = dp[i - 1] + nums[i];
                }
            }
            max = dp[i] > max ? dp[i] : max;
        }
        System.out.println(max);
    }
}