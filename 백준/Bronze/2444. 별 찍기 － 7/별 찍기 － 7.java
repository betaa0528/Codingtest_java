import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void solution(int n) {
        String[] arr = new String[n * 2 - 1];
        for (int i = 0; i < n * 2 - 1; i++) {
            StringBuilder sb = new StringBuilder();
            if(i < n ){
                for (int j = n - (i + 1); j > 0; j--) {
                    sb.append(" ");
                }
                for (int k = 0; k < (i+1) * 2 -1; k++) {
                    sb.append("*");
                }
            }
            else {
                for (int j = (i % n) + 1; j > 0; j--) {
                    sb.append(" ");
                }
                for (int k = 0; k < ((n - (i + 1) % n)) * 2 -1; k++) {
                    sb.append("*");
                }
            }
            arr[i] = sb.toString();
        }
        for(String a : arr) {
            System.out.println(a);
        }
    }
    
     public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        solution(n);
    }
}