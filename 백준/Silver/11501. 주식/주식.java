import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            int len = Integer.parseInt(br.readLine());
            int[] stocks = new int[len];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<len; j++) {
                stocks[j] = Integer.parseInt(st.nextToken());
            }
            long money = 0;
            int cnt = 0;
            // Deque<Integer> q = new ArrayDeque<>();
            int now = stocks[len-1];
            for(int k=len-2; k>=0; k--) {
                if(stocks[k] < now) {
                    cnt++;
                    money -= stocks[k];
                } else {
                    money += cnt * now;
                    now = stocks[k];
                    cnt = 0;
                }
            }
            money += cnt * now;
            System.out.println(money);
        }
    }
}