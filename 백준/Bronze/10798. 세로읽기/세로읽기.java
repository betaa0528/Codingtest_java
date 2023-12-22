import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] arr = new String[5][15];
        StringBuilder sb = new StringBuilder();
        int maxLen = 0;
        int row = 0;
        int col = 0;
        for(int i=0; i<5; i++) {
            arr[i] = br.readLine().split("");
            maxLen = (arr[i].length > maxLen) ? arr[i].length : maxLen;
        }
        while(true) {
            if(col < arr[row%5].length ){
                sb.append(arr[row%5][col]);
            }
            row++;
            if(row%5 == 0) col++;
            if(col == maxLen) break;
        }
        System.out.println(sb.toString());
    }
}