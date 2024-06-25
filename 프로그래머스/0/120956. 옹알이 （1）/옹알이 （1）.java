class Solution {
    public int solution(String[] babbling) {
        int answer= 0;
        String[] words = {"woo", "aya", "ye", "ma"};
        
        for(int i=0; i<babbling.length; i++){
            for(String word : words) {
                babbling[i] = babbling[i].replace(word, "0");
            }
            babbling[i] = babbling[i].replace("0", "");
            if(babbling[i].isEmpty()){
                answer++;
            }
        }
        return answer;

    }
}