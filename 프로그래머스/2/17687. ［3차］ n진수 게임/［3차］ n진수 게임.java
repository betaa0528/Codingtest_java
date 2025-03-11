class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        
        while(sb.length() < t*m) {
            sb.append(Integer.toString(num++, n));
        }
        String str = sb.toString();
        sb = new StringBuilder();
        int idx = p-1;
        while(sb.length() < t) {
            sb.append(str.charAt(idx));
            idx += m;
        }
        return sb.toString().toUpperCase();
    }
}