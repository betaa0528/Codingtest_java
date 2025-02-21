class Solution {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][land[0].length];
        for(int i=0; i<land[0].length; i++) {
            dp[0][i] = land[0][i];
        }
        for(int i=1; i<land.length; i++) {
            for(int j=0; j<4; j++) {
                
                for(int k=0; k<4; k++) {
                    if (j == k) {
                        continue;
                    }
                    dp[i][j] = Math.max(land[i][j] + dp[i-1][k], dp[i][j]);
                }
            }
        }
        
        int answer = 0;
        for(int i=0; i<4; i++) {
            answer = Math.max(dp[dp.length-1][i], answer);
        }

        return answer;
    }
}