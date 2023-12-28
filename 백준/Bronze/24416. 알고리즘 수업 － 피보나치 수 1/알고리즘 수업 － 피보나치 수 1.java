import java.io.*;
public class Main{   
   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        System.out.printf("%d %d", fibo(num), fibonacci(num));
    }

    private static int fibonacci(int n) {
        int[] f = new int[n];
        int cnt = 0;
        f[0] = 1;
        f[1] = 1;
        for(int i=2; i<n; i++) {
            f[i] = f[i-1] + f[i-2];
            cnt++;
        }
        return cnt;
    }

    private static int fibo(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibo(n - 1) + fibo(n - 2);
        }
    }
}