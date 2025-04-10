import java.util.*;
class Solution {
    static long answer;
    public long solution(String expression) {
        answer = 0;
        List<String> list = new ArrayList<>();
        String s = "";
        
        for(int i=0; i<expression.length(); i++) {
            char c = expression.charAt(i);
            
            if(c >= '0' && c <='9') s += c;
            else {
                list.add(s);
                list.add("" + c);
                s = "";
            }
        }
        list.add(s);
        
        
        permutation(0, new int[3], new int[3], list);
        return answer;
    }
    
    public static void calculator(int[] arr, List<String> list) {
        for(int i=0; i<arr.length; i++) {
            String symbol = arr[i] == 0 ? "*" : (arr[i] == 1 ? "+" : "-");
            int idx = 0;
            while(idx < list.size()) {
                String str = list.get(idx);
                if(str.equals(symbol)) {
                    Long result = 0L;
                    if(symbol.equals("*")) result = Long.parseLong(list.get(idx-1)) * Long.parseLong(list.get(idx+1));
                    else if(symbol.equals("+")) result = Long.parseLong(list.get(idx-1)) + Long.parseLong(list.get(idx+1));
                    else if(symbol.equals("-")) result = Long.parseLong(list.get(idx-1)) - Long.parseLong(list.get(idx+1));
                    list.remove(idx-1);
                    list.remove(idx-1);
                    list.remove(idx-1);
                    list.add(idx-1, "" + result);
                    
                } else {
                    idx++;
                }
            }
        }
        Long ans = Long.parseLong(list.get(0));
        if(ans < 0L) ans *= -1;
        answer = Math.max(answer, ans);
    }
    
    public static void permutation(int cnt, int[] arr, int[] visit, List<String> list) {
        if(cnt == 3) {
            calculator(arr, new ArrayList<>(list));
            return ;
        }
        
        for(int i=0; i<3; i++) {
            if(visit[i] == 1) continue;
            arr[cnt] = i;
            visit[i] = 1;
            permutation(cnt+1, arr, visit, list);
            visit[i] = 0;
        }
    }
}