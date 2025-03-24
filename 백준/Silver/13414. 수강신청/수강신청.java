import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Set<String> set = new LinkedHashSet<>();
        for(int i=0; i<L; i++) {
            String input = br.readLine();
            if(set.contains(input)) {
                set.remove(input);
            }
            set.add(input);
            
        }
        int cnt = 0;
        for(String key :set) {
            if(cnt < K){
                System.out.println(key);
                cnt++;
            }
        }
    }
}