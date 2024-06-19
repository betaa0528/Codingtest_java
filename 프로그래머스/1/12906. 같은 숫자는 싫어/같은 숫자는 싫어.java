import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        ArrayList<Integer> result = new ArrayList<>();
        int count = 0;
        result.add(arr[count]);
        for(int a : arr){
            if(result.get(count) != a){
                count++;
                result.add(a);
            }
        }
        int[] answer = new int[result.size()];
        
        for(int i=0 ; i<answer.length; i++){
            answer[i] = result.get(i);
        }
        

        return answer;
    }
}