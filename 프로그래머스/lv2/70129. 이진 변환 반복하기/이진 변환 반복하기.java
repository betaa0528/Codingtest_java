class Solution {
    public int[] solution(String s) {
        int[] cnt = {0,0};
        cntFunc(s, cnt);
        return cnt;
    }
    
    public int[] cntFunc(String s, int[] cnt){
         int tmp = 0;
        if(s.equals("1")){
            return cnt;
        }

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '0') {
                tmp++;
            }
        }

        cnt[0]++;
        cnt[1] += tmp;
        int length = s.length() - tmp;

        return cntFunc(Integer.toString(length, 2) , cnt);
    }
}