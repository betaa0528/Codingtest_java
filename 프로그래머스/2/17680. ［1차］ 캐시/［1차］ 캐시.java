import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        Map<String, Integer> map = new HashMap<>();
        
        int answer = 0;
        for(int i=0; i<cities.length; i++) {
            String city = cities[i].toLowerCase();
            if(!map.containsKey(city) || cacheSize == 0) {
                answer += 5;
                if(map.size() < cacheSize) {
                    map.put(city, i);
                } else {
                    int min = Integer.MAX_VALUE;
                    String del = "";
                    for(String key : map.keySet()) {
                        if(map.get(key) < min) {
                            del = key;
                            min = map.get(key);
                        }
                    }
                    map.remove(del);
                    map.put(city, i);
                }
            } else {
                answer++;
                map.put(city, i);
            }
        }
        return answer;
    }
}