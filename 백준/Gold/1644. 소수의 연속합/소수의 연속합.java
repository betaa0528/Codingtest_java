import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[300000];
        int idx = 0;
        Arrays.fill(arr, -1);
        for(int i=2; i<=N; i++) {
            if(cal(i)) arr[idx++] = i;
        }
        int answer = 0;
        int l = 0; int r = 0;
        int sum = arr[r] + arr[l] - 2;
        while(l <= r) {

            if(sum <= N) {
                r++;
                if(sum == N) {
                    answer++;
                }
                if(arr[r] == -1) break;
                sum += arr[r];
            } else {
                sum -= arr[l];
                l++;
            }
        }
        System.out.println(answer);
    }

    public static boolean cal(int a) {
        for(int i=2; i*i <= a; i++) {
            if(a % i == 0) {
                return false;
            }
        }

        return true;
    }

}
