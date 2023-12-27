import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Integer> ll = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt() + 1;
        while(num --> 1) {
            ll.add(num);
        }
        while(ll.size() > 1) {
            ll.pollLast();
            ll.addFirst(ll.pollLast());
        }
        System.out.println(ll.poll());
    }
}