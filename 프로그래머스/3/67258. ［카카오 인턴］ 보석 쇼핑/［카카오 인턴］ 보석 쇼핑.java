import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        Map<String,Integer> map = new HashMap<>();
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            int result = o1[1] - o1[0] - (o2[1] - o2[0]);
            if(result == 0) {
                result = o1[0] - o2[0];
            }
            return result;
        });
        int idx = 0; 
        
        for(String gem : gems) {
            if(!map.containsKey(gem)) {
                map.put(gem, idx++);
            }
        }
        int[] arr = new int[map.size()];
        
        int l = 0;
        int r = 0;
        int cnt = 1;
        arr[map.get(gems[r])]++;

        while(r < gems.length - 1 && l<=r) {

            if(cnt < map.size()) {
                r++;
                if(arr[map.get(gems[r])] == 0) {
                    cnt++;
                }
                arr[map.get(gems[r])]++;
            } else {
                pq.add(new int[]{l+1, r+1});
                arr[map.get(gems[l])]--;
                if(arr[map.get(gems[l])] == 0) {
                    cnt--;
                }
                l++;
            }
        }
        
        while(cnt == map.size()) {
            pq.add(new int[]{l+1, r+1});
            arr[map.get(gems[l])]--;
            if(arr[map.get(gems[l])] == 0) {
                cnt--;
            }
            l++;
        }
        return pq.poll();
    }
}