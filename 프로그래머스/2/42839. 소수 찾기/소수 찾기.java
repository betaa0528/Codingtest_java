import java.util.*;
class Solution {
    public static Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        int n =numbers.length();
        permutation(numbers, n, 0, new boolean[n], new StringBuilder());
        for(int num : set) {
            if(isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }
    
    public static void permutation(String numbers, int n, int cnt, boolean[] visited, StringBuilder sb) {
        if(cnt == n) {
            return;
        }
        
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                sb.append(numbers.charAt(i) + "");
                set.add(Integer.parseInt(sb.toString()));
                visited[i] = true;
                permutation(numbers, n, cnt+1, visited, sb);
                visited[i] = false;
                sb.delete(sb.length()-1, sb.length());
            }
        }
    }
    
    public static boolean isPrime(int num) {
        if(num < 2) {
            return false;
        }
        for(int i=2; i*i<=num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}