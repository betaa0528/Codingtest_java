import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int aidx = 0;
        int bidx = 0;
        while(bidx < B.length) {
            if(A[aidx] < B[bidx]) {
                aidx++;
                
            } 
            bidx++;
            
        }
        return aidx;
    }
}