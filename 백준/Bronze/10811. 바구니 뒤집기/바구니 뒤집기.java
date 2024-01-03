import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a;
        int b;
        int tmp;
        int[] pocket = new int[n];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            pocket[i] = i+1;
        }

        while(m --> 0){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            int[] reverse = new int[b-a+1];
            for(int j=0; j<b-a+1; j++) {
                reverse[j] = pocket[b-1-j];
            }
            for(int k=0; k<b-a+1; k++) {
                pocket[a-1+k] = reverse[k];
            }
        }
        for(int p : pocket) {
            sb.append(p + " ");
        }
        System.out.println(sb.toString());
    }
}