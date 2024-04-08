import java.util.*;

public class Main{
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] pinaryArr = new long[n];
        if(n == 1 || n == 2) {
            System.out.println(1);
        } else {
            pinaryArr[0] = 1;
            pinaryArr[1] = 1;
            for(int i=2; i<n; i++) {
                pinaryArr[i] = pinaryArr[i-1] + pinaryArr[i-2];
            }
            System.out.println(pinaryArr[n-1]);
        }
    }  
}