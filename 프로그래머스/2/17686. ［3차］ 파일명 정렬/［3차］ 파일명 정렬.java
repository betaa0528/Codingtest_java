import java.util.*;
class Solution {
    static class Node {
        int idx;
        String head;
        String number;
        int num;
        String tail;
        
        public Node(int idx, String head, String number, String tail) {
            this.idx = idx;
            this.head = head;
            this.number = number;
            this.num = number.equals("") ? 0: Integer.parseInt(number);
            this.tail = tail;
        }
        
        public String toString() {
            return idx + " , " + head + " , " + number + " , " + tail;
        }
    }
    public String[] solution(String[] files) {
        
        Queue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            int result = o1.head.toLowerCase().compareTo(o2.head.toLowerCase());
            if(result == 0) {
                result = o1.num - o2.num;
            }
            
            if(result == 0) {
                result = o1.idx - o2.idx;
            }
            return result;
        });
        for(int i=0; i<files.length; i++) {
            pq.add(slice(i, files[i]));
        }
        int idx = 0;
        String[] answer = new String[files.length];
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            answer[idx++] = files[node.idx];
        }
        return answer;
    }
    
    public static Node slice(int idx, String file) {
        String head = "";
        String number = "";
        String tail = "";
        int hidx = 0;
        int cidx = 0;
        boolean hchk = false;
        boolean nchk = false;
        for(int i=0; i<file.length(); i++) {
            char c = file.charAt(i);
            if(!hchk) {
                if((c >= '0' && c <= '9')) {
                    head = file.substring(0, i).toLowerCase();
                    hidx = i;
                    hchk = true;
                }
            } else if(!nchk) {
                if(c < '0' || c > '9' || i - hidx > 4) {
                    number = file.substring(hidx, i);
                    cidx = i;
                    nchk = true;
                }   
            } else {
                break;
            }
        }
        if(!nchk) {
            number = file.substring(hidx, file.length());
            
        } else {
            tail = file.substring(cidx, file.length());
        }
       return new Node(idx, head, number, tail);
    }
}