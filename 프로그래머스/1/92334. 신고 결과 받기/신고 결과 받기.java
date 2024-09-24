import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String , Integer> result = new HashMap<>();
        for(String id : id_list){
            result.put(id , 0);
        }
        int[] answer = new int[id_list.length];
        HashSet<String> hs = new HashSet<>();
        for(String a : report){
            hs.add(a);
        }
        HashMap<String, Integer> reportedPerson = new HashMap<>();
        for(String id : id_list){
            reportedPerson.put(id, 0);
        }
        for(String s : hs){
           reportedPerson.put(s.split(" ")[1], reportedPerson.get(s.split(" ")[1])+1);
        }
        for(String ss : hs){
            if(reportedPerson.get(ss.split(" ")[1]) >= k){
                result.put(ss.split(" ")[0], result.get(ss.split(" ")[0])+1);
            }
        }
        for(String s : id_list){
            for(int i=0 ; i<id_list.length; i++){
                if(id_list[i].equals(s)){
                    answer[i] = result.get(s);
                }
            }
        }
        return answer;
    }
}