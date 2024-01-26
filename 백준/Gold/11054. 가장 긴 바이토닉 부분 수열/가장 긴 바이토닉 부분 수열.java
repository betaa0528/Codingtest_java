import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        int answer = 1;
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int[] dp = new int[N];
        int[] dpR = new int[N];
        st = new StringTokenizer(br.readLine());
        int i = 0;
        while (st.hasMoreTokens()) {
            nums[i++] = Integer.parseInt(st.nextToken());
        }
        dp[0] = 1;
        dpR[N - 1] = 1;

        for (int j = 1; j < dp.length; j++) {
            dp[j] = dpFunction(nums, dp, j);
            dpR[N - j - 1] = dpRFunction(nums, dpR, N - j - 1);
        }
        for(int k=0; k<dp.length; k++) {
            answer = Math.max(answer, dp[k] + dpR[k]);
        }
        System.out.println(answer-1);
    }

    private static int dpRFunction(int[] nums, int[] dpR, int j) {
        int max = 0;
        for (int k = dpR.length - 1; k >= j; k--) {
            if (nums[k] < nums[j]) {
                if (dpR[k] > max) {
                    max = dpR[k];
                }
            }
        }
        return max + 1;
    }

    private static int dpFunction(int[] nums, int[] dp, int j) {
        int max = 0;
        for (int k = 0; k < j; k++) {
            if (nums[k] < nums[j]) {
                if (dp[k] > max) {
                    max = dp[k];
                }
            }
        }
        return max + 1;
    }

}