import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        // Set<Integer> set = new HashSet<>();
        Queue<Integer> asc = new PriorityQueue<>();
        Queue<Integer> desc = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int i=0; i<operations.length; i++) {
            String[] now = operations[i].split(" ");
            if(now[0].equals("I")) {
                int in = Integer.parseInt(now[1]);
                asc.add(in);
                desc.add(in);
            } else {
                if(asc.isEmpty() || desc.isEmpty()) {
                    continue;
                }
                if(now[1].equals("-1")) {
                    int min = asc.poll();
                    desc.remove(min);
                } else {
                    int max = desc.poll();
                    asc.remove(max);
                }
            }
        }
        return asc.isEmpty() ? new int[]{0,0} : new int[]{desc.poll(), asc.poll()};
    }
}