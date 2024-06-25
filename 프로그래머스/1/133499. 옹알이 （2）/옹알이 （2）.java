class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(String babble : babbling) {
            while(true) {
                babble = babble.replaceFirst("aya", "1");
                babble = babble.replaceFirst("ma", "2");
                babble = babble.replaceFirst("woo", "3");
                babble = babble.replaceFirst("ye", "4");
                if(babble.contains("1aya") || babble.contains("2ma") || babble.contains("3woo") || babble.contains("4ye")) {
                    break;
                }
                if(!babble.contains("aya") && !babble.contains("ma") && !babble.contains("woo") && !babble.contains("ye")) {
                    babble = babble.replace("1" , "");
                    babble = babble.replace("2" , "");
                    babble = babble.replace("3" , "");
                    babble = babble.replace("4" , "");
                    if(babble.isEmpty()) {
                        answer++;
                    }
                    break;
                }
            }
        }
        return answer;
    }
}