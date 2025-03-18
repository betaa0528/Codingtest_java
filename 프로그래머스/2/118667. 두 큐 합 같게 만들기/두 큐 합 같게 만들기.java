import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0;
        long sum2 = 0;
        int[] arr = new int[queue1.length + queue2.length];
        
        for(int i=0; i<queue1.length; i++) {
            arr[i] = queue1[i];
            sum1 += queue1[i];
        }
        
        for(int i=0; i<queue2.length; i++) {
            arr[i+queue1.length] = queue2[i];
            sum2 += queue2[i];
        }
        int s1 = 0;
        int e1 = queue1.length-1;
        int s2 = queue1.length;
        int e2 = arr.length-1;
        boolean flag = false;
        while(true) {
            if(s1 > e1 || s2 > e2 || e1 / arr.length > 3 || e2 /arr.length > 3) {
                break;
            }
            
            if(sum1 == sum2) {
                flag = true;
               
                break;
            } else if(sum1 > sum2) {
                int idx = s1 % arr.length;
                sum1 -= arr[idx];
                sum2 += arr[idx];
                s1++;
                e2++;
            } else {
                int idx = s2 % arr.length;
                sum1 += arr[idx];
                sum2 -= arr[idx];
                e1++;
                s2++;
            }
            answer++;
        }
        return flag ? answer : -1;
    }
}