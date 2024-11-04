import java.util.*;
class Solution {
    public String[] solution(String[] orders, int[] course) {
        
        List<String> list = new ArrayList<>();
        for(int i=0; i<course.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            for(int j=0; j<orders.length; j++) {
                permutation(map, customSort(orders[j]), course[i], new char[course[i]], 0, 0);
            }
            List<String> result = mostOrder(course[i], map);
            for(String re : result) {
                list.add(re);
            }
        }
        Collections.sort(list);
        String[] answer = new String[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    public static String customSort(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(char c : arr) {
            sb.append(c);
        }
        return sb.toString();
    }
    
    public static List<String> mostOrder(int cnt, Map<String, Integer> hm) {
        List<String> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        map.put(cnt,2);
        for(String key : hm.keySet()) {
            if(key.length() == cnt && hm.get(key) >= 2) {
                list.add(key);
                if(map.get(cnt) < hm.get(key)) {
                    map.put(cnt, hm.get(key));
                }
            }
        }
        
        for(String key : list) {
            if(hm.get(key) == map.get(cnt)) {
                result.add(key);
            }
        }
        return result;
    }
    
    public static void permutation(Map<String, Integer> map, String order, int cnt, char[] result, int start, int idx) {
        if(cnt > order.length()) {
            return ;
        }
        if(idx == cnt) {
            Arrays.sort(result);
            StringBuilder sb = new StringBuilder();
            for(char c : result) {
                sb.append(c);
            }
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }
        
        for(int i=start; i<order.length(); i++) {
            result[idx] = order.charAt(i);
            permutation(map, order, cnt, result, i+1, idx + 1);
        }
    }
}