import java.util.*;
import java.io.*;
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int r = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}