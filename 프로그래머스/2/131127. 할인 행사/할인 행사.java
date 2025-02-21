import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wmap = new HashMap<>();
        Map<String, Integer> dmap = new HashMap<>();
        for(int i=0; i<want.length; i++) {
            wmap.put(want[i], number[i]);
        }
        int idx=0;
        for(int i=0; i<10; i++) {
            dmap.put(discount[i], dmap.getOrDefault(discount[i], 0) + 1);
            if(chk(want, wmap, dmap)) {
                answer++;
            }
        }
        for(int i=0; i<discount.length - 10; i++) {
        
            dmap.put(discount[i], dmap.getOrDefault(discount[i], 1) - 1);
            dmap.put(discount[i+10], dmap.getOrDefault(discount[i+10], 0) + 1);
            if(chk(want, wmap, dmap)) {
                answer++;
            }
            
        }
        
        return answer;
    }
    
    public static boolean chk(String[] want, Map<String, Integer> wmap, Map<String, Integer> dmap) {
        boolean flag = true;
        for(String w :want) {
            if(dmap.get(w) == null || wmap.get(w) > dmap.get(w)) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}