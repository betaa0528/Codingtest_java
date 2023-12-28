import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] condition = br.readLine().split(" ");
        int len = Integer.parseInt(condition[0]);
        int goal = Integer.parseInt(condition[1]);
        int sum = 0;
        int cnt = 0;
        int[] moneyArr = new int[len];
        for(int i=0; i<len; i++) {
            moneyArr[i] = Integer.parseInt(br.readLine());
        }
        while(len --> 0) {
            if(moneyArr[len] <= goal && moneyArr[len] <= goal - sum ) {
                while(sum <= goal) {
                    sum += moneyArr[len];
                    cnt++;
                }
                sum -= moneyArr[len];
                cnt--;
            }
            if(sum == goal) break;
        }
        System.out.println(cnt);
    }
}