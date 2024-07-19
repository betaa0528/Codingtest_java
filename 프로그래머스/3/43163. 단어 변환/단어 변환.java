import java.util.*;

class Solution {
    public static Set<String> visit;
    public static Map<String, Integer> map;
    public static int answer;
    public int solution(String begin, String target, String[] words) {
        map = new HashMap<>();
        visit = new HashSet<>();
        bfs(begin, target, words);
        return answer;
        
    }
    
    public static void bfs(String begin, String target, String[] words) {
        Deque<String> queue = new ArrayDeque<>();
        queue.push(begin);
        map.put(begin, 0);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (cur.equals(target)) {
                answer = map.get(cur);
                return;
            }
            for (int i = 0; i < words.length; i++) {
                if (!visit.contains(words[i]) && findgap(cur, words[i])) {
                    queue.push(words[i]);
                    map.put(words[i], map.get(cur) + 1);
                    visit.add(words[i]);
                }
            }
        }
    }

    public static boolean findgap(String word1, String word2) {
        int cnt = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                cnt++;
            }
        }
        return cnt == 1;
    }
}