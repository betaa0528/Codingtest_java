class Solution {

    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for(int i=0; i<schedules.length; i++) {
            int cnt = 0;
            int hope = schedules[i] % 100 > 49 ? schedules[i] + 50 : schedules[i] + 10;
            for(int j=0; j<timelogs[i].length; j++) {
                if((startday +j) % 7 == 6 || (startday + j) % 7 == 0) {
                    continue;
                }
                if(timelogs[i][j] <= hope) {
                    cnt++;
                }
                
            }
            if(cnt == 5) {
                answer++;
            }
        }
        return answer;
    }
}