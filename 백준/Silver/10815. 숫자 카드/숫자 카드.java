import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashSet<String> hs = new HashSet<>();
        int len = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (len-- > 0) {
            hs.add(st.nextToken());
        }
        len = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (len-- > 0) {
            if (hs.contains(st.nextToken())) {
                bw.write(1 + " ");
            } else {
                bw.write(0 + " ");
            }
        }
        bw.flush();
        bw.close();
    }
}