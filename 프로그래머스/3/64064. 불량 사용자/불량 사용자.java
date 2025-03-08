import java.util.*;
class Solution {
    public static Set<String> set;
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        backtracking(user_id, banned_id, new boolean[user_id.length], new int[banned_id.length],0);
        System.out.println(set);
        return set.size();
    }
    
    public static void backtracking(String[] user_id, String[] banned_id, boolean[] visit, int[] arr, int cnt) {
        if(cnt == banned_id.length) {
            int[] copy = Arrays.copyOfRange(arr, 0, arr.length);
            Arrays.sort(copy);
            String str = "";
            for(int num : copy) {
                str += num;
            }
            set.add(str);
            return ;
        }
        
        for(int i=0; i<user_id.length; i++) {

            if(!visit[i]) {
                if(chk(user_id[i], banned_id[cnt])) {
                    
                    visit[i] = true;
                    arr[cnt] = i;
                    backtracking(user_id, banned_id, visit, arr, cnt+1);
                    visit[i] = false;
                }
            }
        }
    }
    
    public static boolean chk(String user, String ban) {
        if(user.length() != ban.length()) {
            return false;
        }
        
        for(int i=0; i<user.length(); i++) {
            if(ban.charAt(i) == '*') continue;
            if(user.charAt(i) != ban.charAt(i)) return false;
        }
        
        return true;
    }
}