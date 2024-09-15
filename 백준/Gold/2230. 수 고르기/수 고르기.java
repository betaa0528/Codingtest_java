import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = Integer.MAX_VALUE;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);
        int l = 0;
        int r = 0;
        while(l <= r && r < n) {
            if(nums[r] - nums[l] < m) {
                r++;
            } else {
                answer = Math.min(answer, nums[r] - nums[l]);
                l++;
            }
        }

        System.out.println(answer);
    }
}
