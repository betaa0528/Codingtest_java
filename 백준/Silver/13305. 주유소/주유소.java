import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int station = Integer.parseInt(br.readLine());
        long[] dist = new long[station-1];
        long[] gas = new long[station];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<dist.length; i++) {
            dist[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<gas.length; i++) {
            gas[i] = Long.parseLong(st.nextToken());
        }
        long answer =0;
        long distSum = 0;
        long min = gas[0];
        for(int i=0; i<dist.length; i++) {
            distSum += dist[i];
            if(gas[i+1] <= min) {
                answer += distSum * min;
                distSum = 0;
                min = gas[i+1];
            }
        }
        answer += distSum * min;
        System.out.println(answer);
    }
}
