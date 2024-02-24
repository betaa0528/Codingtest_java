import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        int len = s.length();
        HashSet<String> hs = new HashSet<>();
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < len - i + 1; j++) {
                for (int k = j; k < j + i; k++) {
                    sb.append(s.charAt(k));
                }
                hs.add(sb.toString());
                sb.delete(0, sb.length());
            }
        }
        System.out.println(hs.size());
    }
}