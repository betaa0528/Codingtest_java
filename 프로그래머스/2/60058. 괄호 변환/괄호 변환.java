class Solution {
    public static String answer = "";
    public String solution(String p) {
        answer += seperation(p);
        return answer;
    }
    
    public static boolean check(String p) {
        int result = 0;
        for(int i=0; i<p.length(); i++) {
            if(p.charAt(i) == '(') {
                result++;
            } else {
                result--;
            }
            
            if(result < 0) {
                return false;
            }
        }
        return true;
    }
    
    public static String seperation(String p) {
        int open = 0;
        int close = 0;
        for(int i=0; i<p.length(); i++) {
            if(p.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }

            if(open == close) {
                break;
            }
        }
        String u = p.substring(0, open+close);
        String v = p.substring(open+close, p.length());
        String tmp = "";
        if(check(u)) {
            tmp += u;
            if(check(v)) {
                tmp += v;
            } else {
                tmp += seperation(v);
            }
        } else {
            tmp = "(";
            if(check(v)) {
                tmp += v;
            } else {
                tmp += seperation(v);
            }
            tmp += ")";
            String uCopy = "";
            for(int i=1; i<u.length() - 1; i++) {
                if(u.charAt(i) == '(') {
                    uCopy += ')';
                } else {
                    uCopy += '(';
                }
            }
            tmp += uCopy;
        }
        return tmp;
    }
}