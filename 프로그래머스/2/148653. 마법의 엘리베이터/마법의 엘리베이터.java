class Solution {
    public int solution(int storey) {
        int answer = 0;
        int pre = 0;
        while(storey > 0) {
            if(storey % 10 == 5) {
                answer += 5;
                if(storey / 10 % 10 >= 5) {
                    pre = 1;
                } else {
                    pre = 0;
                }
                
            } else if(storey % 10 >= 5) {
                answer += 10 - storey % 10;
                pre = 1;
            } else {
                answer += storey % 10;
                pre = 0;
            }
            
            storey = storey / 10 + pre;
        }
        return answer;
    }
}