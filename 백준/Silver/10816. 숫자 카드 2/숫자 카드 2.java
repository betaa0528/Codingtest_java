import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1, st2;
        int N = Integer.parseInt(br.readLine());
        st1 = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(br.readLine());
        st2 = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int key1 = Integer.parseInt(st1.nextToken());
            hm.put(key1, hm.getOrDefault(key1, 0) + 1);
        }
        for (int j = 0; j < M; j++) {
            int key2 = Integer.parseInt(st2.nextToken());
            sb.append(hm.getOrDefault(key2, 0) + " ");
        }
        System.out.println(sb.toString().trim());
    }
}