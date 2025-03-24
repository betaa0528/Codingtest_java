import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] carr = {'a','b','k','d','e','g','h','i','l','m','n','x','o','p','r','s','t','u','w','y'};
        int[] arr  = new int[26];
        for(int i=0; i<carr.length;i++) {
            arr[carr[i]-'a'] = i;
        }
        Queue<String> pq = new PriorityQueue<>((o1, o2) -> {
            int len = Math.min(o1.length(), o2.length());
            int result = 0;
            for(int i = 0; i < len; i++) {
                result = arr[o1.charAt(i)- 'a'] - arr[o2.charAt(i) - 'a'];
                if(result != 0) return result;
            }
            if(result == 0) {
                result = o1.length() - o2.length();
            }
            return result;
        });

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            str = str.replaceAll("ng", "x");
            pq.add(str);
        }
        while(!pq.isEmpty()) {
            String str = pq.poll();
            str = str.replaceAll("x", "ng");
            System.out.println(str);

        }
    }
}