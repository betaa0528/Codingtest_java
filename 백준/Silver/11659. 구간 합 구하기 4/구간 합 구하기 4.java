import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] condition = br.readLine().split(" ");
        int n = Integer.parseInt(condition[0]);
        int m = Integer.parseInt(condition[1]);
        int maxSum = 0;
        int[] numArr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num;
        for(int count=0; count<n; count++) {
            num = Integer.parseInt(st.nextToken());
            if(count == 0) {
                numArr[count] = num;
            } else {
                numArr[count] = numArr[count-1] + num;
            }

        }

        while(m --> 0) {
            String[] iToj = br.readLine().split(" ");
            int i = Integer.parseInt(iToj[0]) - 1;
            int j = Integer.parseInt(iToj[1]) - 1;
            if(i == 0) {
                bw.write(numArr[j]+"\n");
            } else if(1 == j) {
                bw.write((numArr[j] -numArr[j-1])+"\n");
            } else {
                bw.write((numArr[j] - numArr[i-1])+"\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}