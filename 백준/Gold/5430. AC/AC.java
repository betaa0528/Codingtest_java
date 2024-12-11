import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        for(int i=0; i<tc; i++) {
            String func = br.readLine();
            int cnt = Integer.parseInt(br.readLine());
            String s = br.readLine();
            String[] arr = s.substring(1, s.length()-1).split(",");
            Deque<String> deque = new ArrayDeque<>();
            for(String a : arr) {
                if(!a.equals("")) {
                    deque.add(a);
                }
            }
            boolean flag = false;
            String answer = "";
            for(int j=0; j<func.length(); j++) {
                if(func.charAt(j) == 'R') {
                    flag = !flag;
                } else if(func.charAt(j) == 'D') {
                    if(deque.isEmpty()) {
                        answer = "error";
                        break;
                    }

                    if(flag) {
                        deque.pollLast();
                    } else {
                        deque.poll();
                    }
                }
            }
            String[] result = new String[deque.size()];
            if(flag) {
                for(int k=0; k<result.length; k++) {
                    result[k] = deque.pollLast();
                }
            } else {
                for(int k=0; k<result.length; k++) {
                    result[k] = deque.pollFirst();
                }
            }
            if(!answer.equals("error")) {
                if(flag){
                    bw.write("[");
                    for(int k=0; k<result.length; k++) {
                        bw.write(result[k]);
                        if(k < result.length-1) {
                            bw.write(",");
                        }
                    }
                    bw.write("]" + "\n");
                } else {
                    bw.write("[");
                    for(int k=0; k<result.length; k++) {
                        bw.write(result[k]);
                        if(k < result.length-1) {
                            bw.write(",");
                        }
                    }
                    bw.write("]" + "\n");
                }
            } else {
                bw.write("error" + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
