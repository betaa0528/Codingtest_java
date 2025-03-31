import java.util.*;
class Solution {
    public static int answer = 0;
    public int solution(int sticker[]) {
        if(sticker.length == 1) return sticker[0];
        if(sticker.length == 2) return Math.max(sticker[0], sticker[1]);
        if(sticker.length == 3) return Math.max(Math.max(sticker[0], sticker[1]), sticker[2]);

        int[] dp1 = new int[sticker.length-1];
        int[] dp2 = new int[sticker.length-1];
        dp1[0] = sticker[0];
        dp1[1] = sticker[1];
        dp1[2] = Math.max(Math.max(sticker[0], sticker[1]), sticker[2] + sticker[0]);
        
        dp2[0] = sticker[1];
        dp2[1] = sticker[2];
        dp2[2] = Math.max(Math.max(sticker[3] +sticker[1], sticker[1]), sticker[2]);
        for(int i=3; i<sticker.length-1; i++) {
            dp1[i] = Math.max(Math.max(dp1[i-2] + sticker[i], dp1[i-1]), dp1[i-3] + sticker[i]);
        }
        for(int i=4; i<sticker.length; i++) {
            dp2[i-1] = Math.max(Math.max(dp2[i-3] + sticker[i], dp2[i-2]), dp2[i-4] + sticker[i]);
        }
 
        return Math.max(dp1[sticker.length-2], dp2[sticker.length-2]);
    }
   
   
}