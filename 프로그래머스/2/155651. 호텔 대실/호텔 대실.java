import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        List<Stack<int[]>> list = new ArrayList<>();
        int[][] times = new int[book_time.length][2];
        int idx = 0;
        for(String[] book : book_time) {
            String[] stime = book[0].split(":");
            String[] etime = book[1].split(":");
            int shour = Integer.parseInt(stime[0]);
            int smin = Integer.parseInt(stime[1]);
            int ehour = Integer.parseInt(etime[0]);
            int emin = Integer.parseInt(etime[1]);
            times[idx][0] = shour * 60 + smin;
            times[idx][1] = ehour * 60 + emin + 10;
            idx++;
        }
        Arrays.sort(times, (o1, o2) -> o1[0] - o2[0]);
        for(int[] time : times) {
            if(list.size() == 0 || list.isEmpty()) {
                list.add(new Stack<>());
            }
            boolean check = false;
            for(Stack<int[]> stack : list) {
                if(stack.isEmpty() || stack.peek()[1] <= time[0]) {
                    stack.push(time);
                    check = true;
                    break;
                }
            }
            
            if(!check) {
                Stack<int[]> s = new Stack<>();
                s.push(time);
                list.add(s);
            }
       }
        // for(int[] time : times) {
        //     System.out.println(Arrays.toString(time));
        // }
        int answer = list.size();
        return answer;
    }
}