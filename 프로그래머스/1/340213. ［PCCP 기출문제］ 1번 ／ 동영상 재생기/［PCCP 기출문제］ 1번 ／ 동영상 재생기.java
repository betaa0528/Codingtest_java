class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int len = Integer.parseInt(video_len.split(":")[0]) * 60 + Integer.parseInt(video_len.split(":")[1]);
        int p = Integer.parseInt(pos.split(":")[0]) * 60+ Integer.parseInt(pos.split(":")[1]);
        int start = Integer.parseInt(op_start.split(":")[0]) * 60 + Integer.parseInt(op_start.split(":")[1]);
        int end = Integer.parseInt(op_end.split(":")[0]) * 60 + Integer.parseInt(op_end.split(":")[1]);
        if(p >= start && p <= end) {
            p = end;
        }
        for(String command : commands) {
            if(command.equals("prev")) {
                p -= 10;
                if(p < 0) {
                    p = 0;
                }
            } else {
                p += 10;
                if(p > len) {
                    p = len;
                }
            }
            
            if(p >= start && p <= end) {
                p = end;
            }
        }
        
        String minute = p / 60 < 10 ? "0" + p/60 : "" + p/60;
        String second = p % 60 < 10 ? "0" + p%60 : "" + p%60;
        String answer = minute + ":" + second;
        return answer;
    }
}