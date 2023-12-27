import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Integer> ll = new LinkedList<>();
        int len = Integer.parseInt(br.readLine());
        while(len --> 0) {
            String str = br.readLine();
            if(str.contains("push")) {
                ll.add(Integer.parseInt(str.split(" ")[1]));
            } else if(str.equals("pop")) {
                if(ll.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(ll.pollFirst() + "\n");
                }
            } else if(str.equals("size")) {
                bw.write(ll.size() + "\n");
            } else if(str.equals("empty")) {
                bw.write(ll.isEmpty() ? 1 + "\n" : 0 + "\n");
            } else if(str.equals("front")) {
                if(ll.isEmpty()) bw.write(-1 + "\n");
                else bw.write(ll.getFirst() + "\n");
            } else if(str.equals("back")) {
                if(ll.isEmpty()) bw.write(-1 + "\n");
                else bw.write(ll.getLast() + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}