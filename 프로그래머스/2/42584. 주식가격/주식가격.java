import java.util.*;
class Solution {
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i=0; i<prices.length; i++){
            answer[i] = pricesFunc(i, prices);
        }
        return answer;
    }

    public static int pricesFunc(int idx, int[] prices) {
        Stack<Integer> stack = new Stack<>();
        for(int j=idx+1; j<prices.length; j++ ) {
            if(prices[idx] <= prices[j]) {
                stack.push(prices[j]);
            }
            if(prices[idx] > prices[j]) {
                stack.push(prices[j]);
                break;
            }
        }
        return stack.size();
    }
}