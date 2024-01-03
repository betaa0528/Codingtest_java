import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int len = Integer.parseInt(br.readLine());
        int[][] paper = new int[100][100];
        int count = 0;
        while(len --> 0){
            String[] arr = br.readLine().split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            for(int i=0; i<10; i++) {
                for(int j=0; j<10; j++) {
                    paper[a-1+i][b-1+j] = 1;
                }
            }
        }
        for(int[] ones : paper) {
            for(int one : ones ) {
                if(one == 1) count++;
            }
        }
        System.out.println(count);
    }
}