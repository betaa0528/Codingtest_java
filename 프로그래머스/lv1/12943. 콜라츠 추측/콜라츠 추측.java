class Solution {
    public int solution(int num) {
        Long num_ = (long) num;
        int cnt = 0;
        while(num_ != 1){
            num_ = num_ % 2 == 0 ? num_ / 2 : num_ * 3 + 1;
            cnt++;
            if(cnt > 500){
                return -1;
            }
        }
        return cnt;

    }
}