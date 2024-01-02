import java.util.*;
import java.io.*;
public class Main {
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        HashSet<String> hs = new HashSet<>();
        String str;
        while (n-- > 0) {
            str = br.readLine();
            if (str.equals("ENTER")) {
                if(!hs.isEmpty()){
                    count += hs.size();
                    hs.clear();
                }
            }
            else {
                hs.add(str);
            }
        }
        count += hs.size();
        System.out.println(count);
    }
}