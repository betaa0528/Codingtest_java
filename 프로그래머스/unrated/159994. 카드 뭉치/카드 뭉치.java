class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        for(String g : goal){
            answer = search(cards1, g).equals("Yes") && search(cards2, g).equals("Yes") ? "Yes" : "No";
            if(answer.equals("No")) return "No";    
        }
        
        return answer;
    }
    
    static String search(String[] cards, String goal) {
        for(int i=0; i< cards.length; i++){
            if(i == 0){
                if(cards[i].equals(goal)){
                    cards[i] = "";
                }
            }
            else{
                if(cards[i].equals(goal)){
                    if(cards[i-1] != ""){
                        return "No";
                    } else {
                        cards[i] = "";
                    }
                }
            }
        }
        return "Yes";
    }
}