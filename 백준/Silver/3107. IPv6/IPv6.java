import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        boolean flag = false;
        if(input.charAt(input.length() - 1) == ':') {
            flag = true;
        }
        String[] split = input.split(":");
        String[] answer = new String[8];
        // 앞
        for(int i=0; i<split.length; i++) {
            if(split[i].isEmpty()) {
                break;
            }

            if(split[i].length() < 4) {
                String format = String.format("%0" + (4 - split[i].length()) + "d", 0);
                split[i] = format + split[i];
            }
            answer[i] = split[i];
        }

        if (!flag) {
            int gap = 8 - split.length;
            for(int i = split.length-1; i>=0; i--) {
                if(split[i].isEmpty()) {
                    break;
                }

                if(split[i].length() < 4) {
                    String format = String.format("%0" + (4 - split[i].length()) + "d", 0);
                    split[i] = format + split[i];
                }
                answer[gap + i] = split[i];
            }

        }


        StringBuilder sb = new StringBuilder();

        for(int i =0; i<answer.length; i++) {
            if(answer[i] == null || answer[i].isEmpty() ) {
                answer[i] = "0000";
            }
            sb.append(answer[i]).append(":");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
}
