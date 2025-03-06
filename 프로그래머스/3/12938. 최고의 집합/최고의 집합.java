import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        if(n > s) {
            return new int[]{-1};
        }
        Arrays.fill(answer, s/n);
        if(s % n != 0) {
            for(int i=1; i<=s%n; i++) {
                answer[n-i] = s/n + 1;
            }
        }

        return answer;
    }
}