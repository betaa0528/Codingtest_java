import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
         
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        
        
        for(int i=0; i<str1.length()-1; i++) {
            String sub = str1.substring(i, i+2);
            if(sub.charAt(0) < 'a' || sub.charAt(0) > 'z') {
                continue;
            }
            if(sub.charAt(1) < 'a' || sub.charAt(1) > 'z') {
                continue;
            }
            list1.add(sub);
            map1.put(sub , map1.getOrDefault(sub, 0) + 1);
        }
        
        for(int i=0; i<str2.length()-1; i++) {
            String sub = str2.substring(i, i+2);
            if(sub.charAt(0) < 'a' || sub.charAt(0) > 'z') {
                continue;
            }
            if(sub.charAt(1) < 'a' || sub.charAt(1) > 'z') {
                continue;
            }
            list2.add(sub);
            map2.put(sub , map2.getOrDefault(sub, 0) + 1);
        }
        
        int inter = 0;
        int sum = 0;
        
        for(String key : map1.keySet()) {
            if(map2.containsKey(key)) {
                inter += Math.min(map1.get(key), map2.get(key));
                sum += Math.max(map1.get(key), map2.get(key));
            } else {
                sum += map1.get(key);
            }
        }
        
        for(String key : map2.keySet()) {
            if(!map1.containsKey(key)) {
                sum += map2.get(key);
            }
        }
        
        
        if(inter == 0 && sum == 0) {
            return 65536;
        } 
    
        
        return (int) ((double)inter / sum * 65536);
    }
}