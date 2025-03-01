import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        // IN 하는 경우 map에 저장
        // OUT 하는 경우 map에서 삭제
        // 시간을 누적 해야함..
        
        // 금액을 누적할 pq 생성
        Map<Integer, Integer> map = new HashMap<>(); // IN때 저장 OUT 삭제
        Map<Integer, Integer> sum = new HashMap<>(); // 누적시간 저장
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for(String record : records) {
            String[] split = record.split(" ");
            String[] stime = split[0].split(":");
            int hour = Integer.parseInt(stime[0]) * 60;
            int min = Integer.parseInt(stime[1]);
            int carNum = Integer.parseInt(split[1]);
                
            if(split[2].equals("IN")) {
                map.put(carNum, hour + min);
            } else {
                int time = hour + min - map.get(carNum);
                sum.put(carNum, sum.getOrDefault(carNum, 0) + time);
                map.remove(carNum);
            }
            
        }
        if(map.size() > 0 ) {
            for(int key : map.keySet()) {
                
                int hour = 23 * 60;
                int min = 59;
                int result = hour + min - map.get(key);
                sum.put(key, sum.getOrDefault(key, 0) + result);
            }
        }
        
        for(int key : sum.keySet()) {
            int fee = feeCalc(sum.get(key), fees);
            pq.add(new int[]{key, fee});
            
        }
        
        int[] answer = new int[pq.size()];
        int idx = 0;
        while(!pq.isEmpty()) {
            answer[idx++] = pq.poll()[1];
        }
        return answer;
    }
    
    public static int feeCalc(int time, int[] fees) {
        if(fees[0] >= time) {
            return fees[1];
        } else {
            time -= fees[0];
            System.out.println(time);
            if(time % fees[2] > 0) {
                return fees[1] + (time / fees[2] + 1) * fees[3];
            } else {
                return fees[1] + time/fees[2] * fees[3];
            }
        }
    }
}