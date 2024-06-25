class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for (String babble : babbling) {
            if (babble.contains("ayaaya") || babble.contains("mama") || babble.contains("woowoo") || babble.contains("yeye")) {
                continue;
            }
            babble = babble.replace("aya", "0");
            babble = babble.replace("ma", "0");
            babble = babble.replace("woo", "0");
            babble = babble.replace("ye", "0");
            babble = babble.replace("0", "");
            if (babble.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}