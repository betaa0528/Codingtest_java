import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        if(score.length < m){
            return 0;
        }

        Arrays.sort(score);
        int length = score.length;
        int sum = 0;
        for(int i=0; i<length/m; i++) {
            sum += score[length-m*(i+1)] * m;
        }

        return sum;
    }
}