class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(String a : arr){
            if(Integer.parseInt(a) > max){
                max = Integer.parseInt(a);
            }
            if(Integer.parseInt(a) < min){
                min = Integer.parseInt(a);
            }
        }
        sb.append(min);
        sb.append(" ");
        sb.append(max);
        return sb.toString();
    }
}