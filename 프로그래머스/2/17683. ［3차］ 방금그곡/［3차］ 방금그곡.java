import java.util.*;
class Solution {
    public static Queue<int[]> pq;
    public static Map<Integer, String> map;
    public String solution(String m, String[] musicinfos) {
        m = trans(m);
        map = new HashMap<>();
        pq = new PriorityQueue<>((o1, o2) -> {
            int result = o2[0] - o1[0];
            if(result == 0) {
                result = o1[1] - o2[1];
            }
            return result;
        });
        for(int i=0; i<musicinfos.length; i++) {
            
            chk(musicinfos[i], i, m);
        }
        
        
        return !pq.isEmpty() ? map.get(pq.poll()[1]) : "(None)";
    }
    
    public static String trans(String s) {
        s = s.replaceAll("C#", "c");
        s = s.replaceAll("D#", "d");
        s = s.replaceAll("F#", "f");
        s = s.replaceAll("G#", "g");
        s = s.replaceAll("A#", "a");
        s = s.replaceAll("B#", "b");
        return s;
    }
    
    public static void chk(String music, int idx, String m) {
        String[] musics = music.split(",");
        String[] s = musics[0].split(":");
        String[] e = musics[1].split(":");
        
        int time = (Integer.parseInt(e[0]) * 60 + Integer.parseInt(e[1])) - (Integer.parseInt(s[0]) * 60 +Integer.parseInt(s[1]));
        String title = musics[2];
        
        map.put(idx, title);
        String melody = musics[3];
        melody = trans(melody);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<time / melody.length(); i++) {
            sb.append(melody);
        } 
        sb.append(melody.substring(0, time % melody.length()));
        
        if(sb.toString().contains(m)) {
            pq.add(new int[]{time, idx});
        }  
    }
}