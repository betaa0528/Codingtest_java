import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int l = 0;
        int r = 0;
        int sum = nums[l];
        while (l <= r) {
            if (sum >= s) {
                answer = Math.min(answer, r - l + 1);
                sum -= nums[l];
                l++;
            } else {
                r++;
                if(r >=n) break;
                sum += nums[r];
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }
}
