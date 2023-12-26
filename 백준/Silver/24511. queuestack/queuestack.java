import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<String> queue = new ArrayDeque<>();
        int qsLen = Integer.parseInt(br.readLine());
        String[] structure = br.readLine().split(" ");
        String[] element = br.readLine().split(" ");
        int cLen = Integer.parseInt(br.readLine());
        String[] cArr = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<structure.length; i++) {
            if(structure[i].equals("0")) {
                queue.add(element[i]);
            }
        }
        for(int j=0; j<cLen; j++) {
            queue.addFirst(cArr[j]);
            sb.append(queue.pollLast());
            sb.append(" ");
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }
}