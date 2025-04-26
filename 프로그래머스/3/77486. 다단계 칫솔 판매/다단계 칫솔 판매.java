// import java.util.*;
// class Solution {
//     public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
//         int n = enroll.length;
//         int[] answer = new int[n];
//         Map<String, Integer> idx = new HashMap<>();
//         for(int i=0; i<n; i++) {
//             idx.put(enroll[i], i);
//         }
        
//         Map<String, String> parents = new HashMap<>();
//         for(int i=0; i<n; i++) {
//             if(referral[i].equals("-")) {
//                 parents.put(enroll[i], "minho");
//                 continue;
//             }
//             parents.put(enroll[i], referral[i]);
//         }
//         for(int i=0; i<seller.length; i++) {
//             int benefit = amount[i] * 100;
//             answer[idx.get(seller[i])] += benefit * 0.9;
//             int give = benefit / 10;
//             String name = seller[i];
//             while(!parents.get(name).equals("minho")) {
//                 name = parents.get(name);
//                 answer[idx.get(name)] += give;
//                 if(give >= 10) {
//                     give = (int) (give/10);
//                     answer[idx.get(name)] -= give;
//                 }
                
//             }
//         }
        
//         return answer;
//     }
// }

import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        int[] answer = new int[n];
        
        Map<String, Integer> idx = new HashMap<>(); // 이름 -> 인덱스 매핑
        for (int i = 0; i < n; i++) {
            idx.put(enroll[i], i);
        }
        
        Map<String, String> parent = new HashMap<>(); // 이름 -> 추천인 매핑
        for (int i = 0; i < n; i++) {
            parent.put(enroll[i], referral[i]);
        }
        
        for (int i = 0; i < seller.length; i++) {
            String now = seller[i];
            int profit = amount[i] * 100; // 개당 100원
            
            while (!now.equals("-") && profit > 0) {
                int give = profit / 10;
                int keep = profit - give;
                
                answer[idx.get(now)] += keep;
                
                now = parent.get(now); // 추천인으로 올라감
                profit = give;
            }
        }
        
        return answer;
    }
}