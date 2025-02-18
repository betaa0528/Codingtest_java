import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int l = 0;
        int r = people.length - 1;
        Arrays.sort(people);
        while(l<=r) {
            int result = limit - people[r];
            if(result >= 40) {
                if(people[l] <= result) {
                    l++;
                }
            }
            answer++;
            r--;
        }
//         int answer = 0;
//         Map<Integer, Integer> map = new HashMap<>();
//         Arrays.sort(people);
//         for(int person : people) {
//             map.put(person, map.getOrDefault(person, 0) + 1);
//         }
//         for(int i=people.length-1; i>=0; i--) {
//             if(map.get(people[i]) == 0) {
//                 continue;
//             }
//             int tmp = limit - people[i];
//             map.put(people[i], map.get(people[i]) - 1);
                     
//             for(int j=tmp; j>=1; j--) {
//                 if(!map.containsKey(j) || map.get(j) == 0 ) {
//                     continue;
//                 }
//                 map.put(j, map.get(j)-1);
//                 break;
//             }
//             answer++;
//         }
        
        return answer;
    }
}