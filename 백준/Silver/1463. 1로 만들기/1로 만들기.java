import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> al = new ArrayList<>();
        al.add(0);
        al.add(0);
        al.add(1);
        al.add(1);
        for(int i=4; i<=n; i++) {
            if(i%6 ==0){
                al.add(Math.min(al.get(i/3), al.get(i/2)) + 1);
            } else if(i%3 == 0) {
                al.add(Math.min(al.get(i/3), al.get(i-1)) + 1);
            } else if(i%2 == 0) {
                al.add(Math.min(al.get(i/2), al.get(i-1)) + 1);
            } else {
                al.add(al.get(i-1) + 1);
            }
        }
        System.out.println(al.get(n));
    }
}