import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int[][] arr = new int[26][str.length()];
        char[] charArray = str.toCharArray();
        for(int i=0; i<26; i++) {
            for(int j=0; j<str.length(); j++) {
                if(charArray[j] == (char) i+97) {
                    arr[i][j] = 1;
                }
            }
        }
        int len = Integer.parseInt(br.readLine());
        while(len --> 0) {
            String[] condition = br.readLine().split(" ");
            int l = Integer.parseInt(condition[1]);
            int r = Integer.parseInt(condition[2]);
            int num = (int)condition[0].charAt(0) - 97;
            int count = 0;
            for(int k = l; k<r+1; k++) {
                if(arr[num][k] == 1) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}