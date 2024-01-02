import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n+1];
        arr[0] = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
            if(i >= k) {
                sum -= arr[i - k];
                max = sum > max ? sum : max;
            }
        }
        System.out.println(max);
    }
}