import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : tangerine) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        for(int key : hashMap.keySet()) {
            list.add(hashMap.get(key));
        }
        list.sort(Collections.reverseOrder());
        int sum = 0;
        int answer = 0;
        for(int number : list) {
            sum += number;
            answer++;
            if(sum >= k) break;
        }
        return answer;
    }
}