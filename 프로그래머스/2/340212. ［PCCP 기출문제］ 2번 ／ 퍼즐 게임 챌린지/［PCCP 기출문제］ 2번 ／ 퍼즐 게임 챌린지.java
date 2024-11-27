class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int max = 0;
        for(int diff : diffs) {
            max = Math.max(max , diff);
        }
        int left = 0;
        int right = max;
        int mid = (left + right) / 2 < 1? 1 : (left+right) / 2;
        long total = Integer.MAX_VALUE;
        int answer = Integer.MAX_VALUE;
        while(mid >0 && left <= right) {
            long sum = 0;
            for(int i=0; i<diffs.length; i++) {
                if(diffs[i] > mid) {
                    sum += times[i] + (diffs[i] - mid) * (times[i] + times[i-1]);
                } else {
                    sum += times[i];
                } 
            }
            
            if(sum > limit) {
                left = mid + 1;
                mid = (left + right + 1) / 2;
            } else {
                total = sum;
                answer = Math.min(answer , mid);
                right = mid - 1;
                mid = (left + right + 1)/ 2;
            }
        }
        return answer;
    }
}