import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String[] cloth : clothes) {
            hashMap.put(cloth[1], hashMap.getOrDefault(cloth[1],0) + 1);

        }
        int sum = 1;
        for (Integer value : hashMap.values()) {
            sum *= value+1;
        }
        return sum - 1;
    }
}