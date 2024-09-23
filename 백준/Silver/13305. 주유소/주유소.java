import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int station = Integer.parseInt(br.readLine());
        int[] dist = new int[station-1];
        int[] gas = new int[station];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<dist.length; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<gas.length; i++) {
            gas[i] = Integer.parseInt(st.nextToken());
        }
        int answer = dist[0] * gas[0];
        int distSum = 0;
        int min = gas[1];
        for(int i=1; i<dist.length; i++) {
            distSum += dist[i];
            if(gas[i+1] <= min) {
                answer += distSum * min;
                distSum = 0;
                min = gas[i+1];
            }
        }
        System.out.println(answer);
    }
}
