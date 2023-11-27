import java.util.*;
class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int max = arr[arr.length - 1];
        int cnt = 1;
        while (true) {
            for (int i = 0; i < arr.length - 1; i++) {
                if((max * cnt) % arr[i] != 0) break;

                if(i == arr.length-2) return max*cnt;
            }
            cnt++;
        }
    }
}