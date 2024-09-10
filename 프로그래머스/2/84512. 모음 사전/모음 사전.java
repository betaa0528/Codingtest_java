import java.util.*;
class Solution {
    public static Set<String> set = new HashSet<>();
    public int solution(String word) {
        int answer = 0;
        String[] arr = {"A", "E", "I", "O", "U"};
        bfs(arr, 0, "");
        String[] words = new String[set.size()];
        int idx = 0;
        for(String s : set) {
            words[idx++] = s;
        }
        
        Arrays.sort(words);
        
        for(int i=0; i<words.length; i++) {
            if(words[i].equals(word)) {
                answer = i;
            }
        }
        return answer + 1;
    }
    
    public static void bfs(String[] arr, int cnt, String str){
        if(cnt == 5) {
            return;
        }
        
        for(int i=0; i<5; i++) {
            str += arr[i];
            set.add(str);
            bfs(arr, cnt + 1, str);
            str = str.substring(0, str.length() - 1);
        }
   }
}