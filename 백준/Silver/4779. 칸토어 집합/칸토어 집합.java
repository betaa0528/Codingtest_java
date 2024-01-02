import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String len;
        while((len =br.readLine()) != null) {
            int n = Integer.parseInt(len);
            int pow = (int) Math.pow(3, n);
            char[] arr = new char[pow];
            StringBuilder sb = new StringBuilder();
            Arrays.fill(arr, '-');
            solution(arr, 0, pow, n);
            for (char a : arr) {
                sb.append(a);
            }
            System.out.println(sb.toString());
        }
    }
    public static void solution(char[] arr, int start, int end, int n) {
        if(n == 0) return;
        int pow = (int)Math.pow(3, n-1);
        for(int i=start+pow; i<end-pow; i++) {
            arr[i] = ' ';
        }
        solution(arr, start, start+pow, n-1);
        solution(arr, end-pow, end, n-1);
    }
}