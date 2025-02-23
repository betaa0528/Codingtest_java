import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<skill.length(); i++) {
            map.put(skill.charAt(i), i);
        }
        for(String sk : skill_trees) {
            int cnt = 0;
            boolean flag = true;
            for(int i=0; i<sk.length(); i++) {
                if(!map.containsKey(sk.charAt(i))) {
                    continue;
                }
                if(map.get(sk.charAt(i)) != cnt) {
                    flag = false;
                    break;
                }
                cnt++;
            }
            if(flag) {
                answer++;
            }
        }
        return answer;
    }
}