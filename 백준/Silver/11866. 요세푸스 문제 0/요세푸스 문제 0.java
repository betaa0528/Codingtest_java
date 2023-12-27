import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        LinkedList<Integer> ll = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int idx = 0;
        while(start++ < N){
            ll.add(start);
        }
        sb.append("<");
        while(!ll.isEmpty()) {
            idx = (idx+K-1) % ll.size();
            sb.append(ll.get(idx));
            ll.remove(idx);
            if(!ll.isEmpty()) {
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb.toString());
    }
}