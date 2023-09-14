class Solution {
    boolean solution(String s) {
        int result = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                result++;
            }

            if(s.charAt(i) == ')'){
                result--;
            }

            if(result < 0){
                return false;
            }
        }
        if(result > 0) {
            return false;
        }
        return true;
    }
}