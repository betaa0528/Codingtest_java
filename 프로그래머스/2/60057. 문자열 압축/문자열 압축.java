import java.util.*;
class Solution {
    static int answer;
    public int solution(String s) {
        answer = 1001;
        int n = s.length() / 2;
        for(int i=1; i<=n; i++) {
            compress(i, s, n);
        }
        return answer > s.length() ? s.length() : answer;
    }
    
    public static void trans(String s, int n, Map<String, Integer> map) {
        String copy = s;
        for(String key : map.keySet()) {
            int cnt = map.get(key);
            
            for(int i = cnt; i>1; i--) {
                
                copy = copy.replace(key.repeat(i), i + key );
                // copy = copy.replace(key.repeat(cnt), cnt + key );
                System.out.println(n +", " + i + ", " + copy);
            }
            
        }
        answer = Math.min(answer, copy.length());
    }
    
    public static void compress(int n, String s, int half) {
        Map<String, Integer> map = new HashMap<>();
        String prev = "";
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<=s.length() - n; i += n) {
            int end = i+n > s.length() ? s.length() : i + n;
            String str = s.substring(i, end);
            if(str.equals(prev)) {
                cnt++;
            } else {
                sb.append(cnt > 1 ? cnt+prev : prev);
                prev = str;
                cnt = 1;
            }
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        // System.out.println(sb.toString() + " , " + s.substring(s.length() - n + 1, s.length()));
        sb.append(cnt > 1 ? cnt+prev : prev);
        
        sb.append(s.substring(s.length() - s.length() % n, s.length()));

        // System.out.println(n + ", " + sb.toString() +" ," + s.substring(s.length() - s.length() % n, s.length()));
        answer = Math.min(sb.length(), answer);
    }
}