import java.util.*;
class Solution {
    public static Set<Integer> set;
    // 7 9 1 1 4 7 9 1 1 4
    public int solution(int[] elements) {
        set = new HashSet<>();
        
        for(int i=1; i<=elements.length; i++) {
            int sum = 0;
            for(int j=0; j<i; j++) {
                sum += elements[j];
            }
            set.add(sum);
            for(int k=0; k<elements.length; k++){
                int idx = (k + i) % elements.length;
                sum = sum - elements[k] + elements[idx];
                set.add(sum);
                
            }
        }
        return set.size();
    }
    
}