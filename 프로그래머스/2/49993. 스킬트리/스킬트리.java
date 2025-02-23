import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String sk : skill_trees) {
            String s = sk.replaceAll("[^" + skill + "]", "");
            if(skill.startsWith(s) || s.equals(skill)) {
                answer++;
            }
        }
        return answer;
    }
}