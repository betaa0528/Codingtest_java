class Solution {
    public static int answer;
    public int solution(int[] picks, String[] minerals) {
        answer = Integer.MAX_VALUE;
        backtracking(picks, minerals, 0, 0);
        return answer;
    }
    public static void backtracking(int[] picks, String[] minerals, int s, int sum) {
        if(picksCheck(picks) || s >= minerals.length) {
            answer = Math.min(answer, sum);
            return ;
        }
        int tmp = sum; 
        for(int i=0; i<picks.length; i++) {
            if(picks[i] == 0) {
                continue;
            }
            for(int j=s; j<s+5; j++) {
                if(j >= minerals.length) {
                    break;
                }
                String mineral = minerals[j];
                if(mineral.equals("diamond")) {
                    if(i ==0) {
                        tmp +=1;
                    } else if(i==1) {
                        tmp += 5;
                    } else {
                        tmp += 25;
                    }
                } else if(mineral.equals("iron")) {
                    if(i == 0 || i == 1) {
                        tmp += 1;
                    } else {
                        tmp += 5;
                    }
                } else if(mineral.equals("stone")) {
                    tmp += 1;
                }
            }
            picks[i]--;
            backtracking(picks, minerals, s+5, tmp);
            tmp = sum;
            picks[i]++;
        }
    }
    
    public static boolean picksCheck(int[] picks) {
        int sum = 0;
        for(int p : picks) {
            sum += p;
        }
        return sum == 0;
    }
}