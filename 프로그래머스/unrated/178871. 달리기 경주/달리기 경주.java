import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> strInt = new HashMap<>();
        HashMap<Integer, String> intStr = new HashMap<>();

        for(int i=0; i< players.length; i++){
            strInt.put(players[i] , i+1);
            intStr.put(i+1, players[i]);
        }
        int rank = 0;

        for(String calling : callings) {
            if(strInt.containsKey(calling)) {
                rank = strInt.get(calling);
                intStr.replace(rank , intStr.get(rank-1));
                intStr.replace(rank-1, calling);

                strInt.replace(calling, rank-1);
                strInt.replace(intStr.get(rank), rank);
            }
        }
        String[] answer = new String[players.length];
        for(int j=0; j<strInt.size(); j++){
            answer[j] = intStr.get(j+1);
        }
        
        return answer;
    }
}