import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
//		= new StringTokenizer(br.readLine(), " ");
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            int data[] = new int[n];
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j<n; j++) {
                data[j] = Integer.parseInt(st.nextToken());
            }
            int max = data[n-1];
            long sum = 0;
            for(int k = n-1; k>=0; k--) {
                if(data[k]<=max) {
                    sum += max- data[k];
                }else {
                    max = data[k];
                }
            }
            System.out.println(sum);
        
        }
    }
}