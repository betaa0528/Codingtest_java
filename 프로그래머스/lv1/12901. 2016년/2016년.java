class Solution {
    public String solution(int a, int b) {
        String[] day = { "FRI", "SAT", "SUN" , "MON", "TUE", "WED", "THU"};
        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String answer = null;
        int sum = 0;
        for(int i=0; i<a-1; i++){
            sum += month[i];
        }
        for(int j=0; j<sum+b; j++){
            answer = day[j%7];
        }
        return answer;
    }
}