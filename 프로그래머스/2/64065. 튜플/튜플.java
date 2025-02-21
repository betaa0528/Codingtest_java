import java.util.*;
class Solution {
    public int[] solution(String s) {
        Set<Integer> set = new HashSet<>();
        s = s.replaceAll("[{}]", " ").trim();
        String[] arr = s.split(" , ");
        
        Arrays.sort(arr, (o1, o2) -> o1.length() - o2.length());
        int[] answer = new int[arr.length];
        int idx = 0;
        for(String s1 : arr) {
            for(String s2 : s1.split(",")) {
                int num = Integer.parseInt(s2);
                if(!set.contains(num)) {
                    set.add(num);
                    answer[idx++] = num;
                }
            }
        }
        return answer;
        
    }
}