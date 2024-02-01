import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int len = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] keys = new int[len];
        int[] dp = new int[len];
        int max = 0;
        int answer = 0;
        for (int i = 0; i < len; i++) {
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            keys[i] = key;
            hm.put(key, value);
        }
        Arrays.sort(keys);
        dp[0] = 1;
        for(int j=1; j<len; j++) {
            for(int k=0; k<j; k++) {
                if(hm.get(keys[j]) > hm.get(keys[k]) && dp[k] > max) {
                    max = dp[k];
                }
            }
            dp[j] = max + 1;
            answer = Math.max(dp[j], answer);
            max = 0;
        }
        System.out.println(len - answer);
    }
}