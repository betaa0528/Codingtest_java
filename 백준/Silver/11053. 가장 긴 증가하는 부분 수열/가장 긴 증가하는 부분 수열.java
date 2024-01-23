import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int max = 1;
        int[] nums = new int[N];
        int[] dp = new int[N];
        st = new StringTokenizer(br.readLine());
        int i = 0;
        while (st.hasMoreTokens()) {
            nums[i++] = Integer.parseInt(st.nextToken());
        }
        dp[0] = 1;

        for(int j=1; j<dp.length; j++) {
            dp[j] = solution(nums, dp, j);
            max = Math.max(dp[j], max);
        }

        System.out.println(max);

    }

    private static int solution(int[] nums, int[] dp, int j) {
        int max = 0;
        for(int k = 0; k<j; k++) {
            if(nums[k] < nums[j]) {
                if(dp[k] > max) {
                    max = dp[k];
                }
            }
        }
        return max+1;
    }
        
}