import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        for(int i=1; i<=N; i++) {
            String name = br.readLine();
            map1.put(name, "" + i);
            map2.put("" + i , name);
        }
        
        for(int i = 0; i<M; i++) {
            String find = br.readLine();
            if(find.charAt(0) >= '0' && find.charAt(0) <= '9') {
                System.out.println(map2.get(find));
            } else {
                System.out.println(map1.get(find));
            }
        }
    }
}