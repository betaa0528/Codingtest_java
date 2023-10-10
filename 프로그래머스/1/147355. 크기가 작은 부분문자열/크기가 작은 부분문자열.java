class Solution {
    public int solution(String t, String p) {
        Long longP = Long.parseLong(p);
        int result = 0;
        boolean chk =true;
        for (int i = 0; i < t.length() - p.length() + 1; i++) {
            result += longP >= Long.parseLong(t.substring(i, p.length() + i)) ? 1 : 0;
        }
        return result;
    }
}