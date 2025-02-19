import java.util.*;

public class Solution {
    public int solution(int n) {
        
        
        int ans = 0;
        while(n > 0) {
            if(n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
                ans++;
            }
        }
        // 5000 , 2500 , 1250 , 625, 624(1) , 312, 156, 78, 39, 38(2), 19, 18(3), 9, 8(4), 4, 2, 1(5), 0
        return ans;
    }
}