class Solution {
    public String solution(String phone_number) {
        char[] charArray = phone_number.toCharArray();
        int len = charArray.length;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<len; i++) {
            if(i < len-4) charArray[i] = '*';
            sb.append(charArray[i]);
        }
        return sb.toString();
    }
}