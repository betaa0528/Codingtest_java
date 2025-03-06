import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        int cnt = 0;
        int gap = w * 2 + 1;
        int s = 1;
        int e = 0;
        for(int i=0; i<stations.length; i++) {
            e = stations[i] - w;
            if(s < e) {
                cnt += (e - s + gap - 1) / gap;            
            }
            
            s = stations[i] + w + 1;
        }
        if(s <= n) {
            cnt += (n - s + gap) / gap;        
        }
        
       
        return cnt;
    }
    
    
}