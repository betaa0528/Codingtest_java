import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] f = br.readLine().split(" ");
        int c = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        if(Integer.parseInt(f[0]) * n + Integer.parseInt(f[1]) <= c * n && Integer.parseInt(f[0]) <= c) System.out.println(1);
        else System.out.println(0);
    }
}