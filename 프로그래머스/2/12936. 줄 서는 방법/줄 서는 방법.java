import java.util.*;
class Solution {
    public static int a;
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<= n; i++) {
            list.add(i);
        }
        k--;
        long fact = 1;
        for(int i=2; i<=n; i++) {
            fact *= i;
        }
        
        for(int i=0; i<n; i++) {
            fact = fact / (n-i);
            int idx = (int)(k / fact);
            answer[i] = list.get(idx);
            list.remove(idx);
            k %= fact;
        }
        return answer;
    }
}
// [1, 2, 3] 0 
// [1, 3, 2] 1
// [2, 1, 3] 2
// [2, 3, 1] 3
// [3, 1, 2] 4 0
// [3, 2, 1] 5 1
    
// [4, 1, 2, 3] 18 0
// [4, 1, 3, 2] 19 1
// [4, 2, 1, 3] 20 2 1
// [4, 2, 3, 1] 21 3 2
// [4, 3, 1, 2] 22 4 0
// [4, 3, 2, 1] 23 5 1
    // 119 23 5 1 0
    
