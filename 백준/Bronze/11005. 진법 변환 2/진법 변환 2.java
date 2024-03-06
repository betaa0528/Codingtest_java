import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        Character[] arr = null;
        if (B > 10) {
            arr = new Character[B - 10];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (char) ('A' + i);
            }
        }
        if (B > 10) {
            while (true) {
                if (N % B > 9) sb.append(arr[N % B - 10]);
                else sb.append(N % B);
                N /= B;
                if (B > N) {
                    if (N > 9) sb.append(arr[N - 10]);
                    else if(N > 0) sb.append(N);
                    break;
                }
            }
        } else {
            while (true) {
                sb.append(N % B);
                N /= B;
                if (B > N) {
                    if(N > 0) sb.append(N);
                    break;
                }
            }
        }
        String answer = sb.reverse().toString();
        System.out.println(answer);
    }
}