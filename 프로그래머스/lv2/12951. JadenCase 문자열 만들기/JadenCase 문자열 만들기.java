class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                sb.append(String.valueOf(s.charAt(i)).toUpperCase());
            } else if (s.charAt(i - 1) == ' ') {
                sb.append(String.valueOf(s.charAt(i)).toUpperCase());
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}