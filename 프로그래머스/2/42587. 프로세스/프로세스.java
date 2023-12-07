class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int len = priorities.length;
        int idx = 0;
        int max = 0;
        int maxIdx = 0;
        while(true) {
            if(len == 1) return 1;
            
            if(priorities[idx % len] > max) {
                max = priorities[idx % len];
                maxIdx = idx % len;
                idx = maxIdx;
            }
            if(idx % len == maxIdx && idx > maxIdx) {
                priorities[maxIdx] = 0;
                answer++;
                max = 0;
                idx = maxIdx;
                if(maxIdx % len == location) return answer;
            }
            idx++;
        }
    }
}