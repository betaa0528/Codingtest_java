import java.util.*;
class Solution {
    public long solution(int[] sequence) {
        long answer = Integer.MIN_VALUE;
        int len = sequence.length;
        int[] plus = Arrays.copyOfRange(sequence, 0, len);
        int[] minus = Arrays.copyOfRange(sequence, 0, len);
        long[] dpPlus = new long[len];
        long[] dpMinus = new long[len];
        for(int i=0; i<len; i++) {
            if(i % 2 == 0) {
                minus[i] = sequence[i] * -1;
            } else {
                plus[i] = sequence[i] * -1;
            }
        }
        dpPlus[0] = plus[0];
        dpMinus[0] = minus[0];
        answer = Math.max(plus[0], minus[0]);
        for(int i=1; i<len; i++) {
            if(dpPlus[i-1] < 0 && plus[i] > dpPlus[i-1]) {
                dpPlus[i] = plus[i];
            } else {
                dpPlus[i] = dpPlus[i-1] + plus[i];
            }
            
            if(dpMinus[i-1] < 0 && minus[i] > dpMinus[i-1]) {
                dpMinus[i] = minus[i];
            } else {
                dpMinus[i] = dpMinus[i-1] + minus[i];
            }
            answer = Math.max(Math.max(dpMinus[i], dpPlus[i]), answer);
        }
        return answer;
    }
}