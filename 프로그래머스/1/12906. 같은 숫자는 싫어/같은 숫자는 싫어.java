import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int target = arr[0];
        int[] answer = new int[arr.length];
        answer[0] = arr[0];
        int answerPointer = 1;
        for (int num : arr) {
            if(num != target){
                target = num;
                answer[answerPointer++] = num;
            }
        }
        return Arrays.copyOfRange(answer, 0, answerPointer);
    }
}