import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String S = st.nextToken();
        String E = st.nextToken();
        String Q = st.nextToken();
        int s = Integer.parseInt(S.split(":")[0]) * 60 + Integer.parseInt(S.split(":")[1]);
        int e = Integer.parseInt(E.split(":")[0]) * 60 + Integer.parseInt(E.split(":")[1]);
        int q = Integer.parseInt(Q.split(":")[0]) * 60 + Integer.parseInt(Q.split(":")[1]);
        Set<String> set = new HashSet<>();
        int answer = 0;
        while(true) {
            String input = br.readLine();
            if(input == null || input.isEmpty()) {
                break;
            }
            String[] split = input.split(" ");
            int time = Integer.parseInt(split[0].split(":")[0]) * 60 + Integer.parseInt(split[0].split(":")[1]);
            if(time > q) {
                break;
            }
            if(time <= s) {
                set.add(split[1]);
            } else if(time >= e && time <= q) {
                if(set.contains(split[1])) {
                    answer++;
                    set.remove(split[1]);
                }
            }
        }
        System.out.println(answer);
    }
}