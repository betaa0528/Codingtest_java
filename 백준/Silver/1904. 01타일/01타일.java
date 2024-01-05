import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(0);
        dp.add(1);
        dp.add(2);
        for (int i = 3; i <= N; i++) {
            dp.add((dp.get(i - 2) + dp.get(i - 1)) % 15746);           
        }
        System.out.println(dp.get(N));
    }
}