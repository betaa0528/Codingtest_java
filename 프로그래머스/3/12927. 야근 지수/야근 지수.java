import java.util.*;


class Solution {
    public long solution(int n, int[] works) {
        long sum = 0;
        Arrays.sort(works);
        int len = works.length-1;
        long[] arr = new long[50001];
        for(int work : works) {
            arr[work]++;
        }
        
        for(int i=50000; i>0; i--) {
            if(n <= 0) break;
            if(arr[i] == 0) continue;
            long avaliable = Math.min(n, arr[i]);
            
            n -= avaliable;
            arr[i] -= avaliable;
            arr[i-1] += avaliable;
            
        }
        
        for(int i=0; i<50001; i++) {
            if(arr[i] == 0) continue;
            sum += (i * i * arr[i]);
        }
        
        return sum;
    }
}