import java.io.*;
import java.util.*;
public class Main{
    static long[] lan;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        long maxLan = Integer.MIN_VALUE;

        lan = new long[k];

        for (int i = 0; i < k; i++) {
            lan[i] = Integer.parseInt(br.readLine());
            maxLan = Math.max(maxLan, lan[i]);
        }

        System.out.println(cutLan(1, maxLan));
    }

    private static long cutLan(long minLan, long maxLan) {
        while (minLan <= maxLan) {
            long mid = (minLan + maxLan) / 2;
            long cnt = 0;
            for (long l : lan) {
                cnt += l / mid;
            }
            if(cnt < n) {
                maxLan = mid - 1;
            } else {
                minLan = mid + 1;
            }
        }
        return maxLan;
    }
}