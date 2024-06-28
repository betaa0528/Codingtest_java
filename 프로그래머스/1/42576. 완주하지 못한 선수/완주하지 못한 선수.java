import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        int cnt = 0;
        while(cnt!=completion.length){
            if(!participant[cnt].equals(completion[cnt])) {
                return participant[cnt];
            }
            cnt++;
        }
        return participant[cnt];
    }
}