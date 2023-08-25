class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] alphabetArr = new int[26];

        for(int i=0 ; i<s.length(); i++){
            if(alphabetArr[s.charAt(i)-97] == 0){
                answer[i] = -1;
                alphabetArr[s.charAt(i)-97] = i+1;
            } else {
                answer[i] = Math.abs(alphabetArr[s.charAt(i)-97]-i-1);
                alphabetArr[s.charAt(i)-97] = i+1;
            }

        }
        return answer;
    }
}