import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Integer> list = collatz(k);
        int n = list.size() - 1;
        double[] arr = new double[list.size()];
        area(0, list.size(), arr, list);
        double[] answer = new double[ranges.length];
        int idx = 0;
        for(int[] range : ranges) {
            double result = 0;
            if(range[0] == 0 && range[1] == 0) {
                result = arr[n];
            } else {
                if(n +range[1] >= arr.length || range[0] > n + range[1]) {
                    result = -1;
                } else {
                   result = arr[n + range[1]] - arr[range[0]];                   
                }
            }
            answer[idx++] = result;
        }
        return answer;
    }
    // 너비 구하기
    
    public static void area(int s, int e, double[] arr, List<Integer> list) {
        for(int i=1; i<list.size(); i++) {
            int max = Math.max(list.get(i) , list.get(i-1));
            int min = Math.min(list.get(i) , list.get(i-1));
            double result = (double) (max - min) / 2 + min;
            arr[i] = result + arr[i-1];
        }
    }
    
    
    // 우박수구하기
    public static List<Integer> collatz(int k) {
        List<Integer> list = new ArrayList<>();
        
        while(k>1) {
            list.add(k);
            if(k % 2 == 0) {
                k /= 2;
            } else {
                k = k * 3 + 1;
            }
        }
        
        list.add(1);
        return list;
    }
}