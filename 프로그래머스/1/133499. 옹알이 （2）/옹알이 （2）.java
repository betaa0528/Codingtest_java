class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] words = {"aya", "ye", "woo", "ma"};
        for (String babble : babbling) {
            for(String word : words) {
                if(babble.contains(word + word)) {
                    continue;
                }
                babble = babble.replace(word, "0");
            }
            babble = babble.replace("0", "");
            if (babble.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}