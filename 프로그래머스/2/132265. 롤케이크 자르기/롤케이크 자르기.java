import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int[] arr1 = new int[10001];
        int[] arr2 = new int[10002];
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        if(topping.length == 0) {
            return 0;
        }
        arr1[topping[0]]++;
        set1.add(topping[0]);
        for(int i=1;i<topping.length; i++) {
            arr2[topping[i]]++;
            set2.add(topping[i]);
        }
        
        if(set1.size() == set2.size()) {
            answer++;
        }
        for(int i=1; i<topping.length; i++) {
            arr1[topping[i]]++;
            arr2[topping[i]]--;
            set1.add(topping[i]);
            if(arr2[topping[i]] == 0){
                set2.remove(topping[i]);
            }
            if(set1.size() == set2.size()) {
                answer++;
            }
            
        }
        return answer;
    }
}