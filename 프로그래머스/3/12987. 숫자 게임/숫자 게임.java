import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int aidx = 0;
        int bidx = 0;
        while(bidx < B.length) {
            if(A[aidx] >= B[bidx]) {
                bidx++;
            } else {
                answer++;
                aidx++;
                bidx++;
            }
        }
        return answer;
        // 1 3 5 7
        // 2 6 8 2
    }
}