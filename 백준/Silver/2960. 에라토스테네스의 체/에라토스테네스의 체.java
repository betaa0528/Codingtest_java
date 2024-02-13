import java.util.*;
import java.io.*;
public class Main{
    static int[] nums;
    static int cnt;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        nums = new int[N-1];
        boolean[] check = new boolean[N];
        int start = 2;
        cnt = 0;
        int answer = 0;
        for(int i=0; i<nums.length; i++) {
            nums[i] = start++;
            check[i] = true;
        }
        for(int j=0; j<nums.length; j++) {
            if(check[j]) {
                for(int k=j; k<nums.length; k += nums[j]) {
                    if(check[k]) {
                        check[k] = false;
                        cnt++;
                        if(cnt == K) answer = nums[k];
                    }
                }
            }
            if(cnt >= K) break;
        }
        System.out.println(answer);
    }
}