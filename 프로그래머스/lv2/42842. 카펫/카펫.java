class Solution {
    public int[] solution(int brown, int yellow) {
        int length = (brown + yellow);
        int[] answer = new int[2];
        for(int i=3; i<length; i++) {
            if(length/i >= i && length%i == 0) {
                if((length/i - 2) * (i-2)  == yellow){
                    answer[0] = length/i;
                    answer[1] = i;
                }
            }
        }
        return answer;
    }
}