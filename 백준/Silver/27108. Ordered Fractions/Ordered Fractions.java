import java.util.*;

public class Main {

    static class Node {
        double result;
        String data;

        public Node(double result, String data) {
            this.result = result;
            this.data = data;
        }
    }
    public static Set<Double> set;
    public static Queue<Node> pq;
    public static void main(String[] args) {
        set = new HashSet<>();
        pq = new PriorityQueue<>((o1, o2) -> Double.compare(o1.result, o2.result));
        Scanner sc = new Scanner(System.in);
        makeFraction(sc.nextInt());

        System.out.println(set.size());
        while(!pq.isEmpty()) {
            System.out.println(pq.poll().data);
        }
    }

    public static void makeFraction(int n) {
        for(int i=1; i<=n; i++) {
            for(int j=0; j<=i; j++) {
                double result = (double) j / i;
                if(!set.contains(result)) {
                    set.add(result);
                    pq.add(new Node(result, j + "/" + i));
                }
            }
        }
    }
}
